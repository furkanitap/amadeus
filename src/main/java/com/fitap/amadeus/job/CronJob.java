package com.fitap.amadeus.job;

import com.fitap.amadeus.model.Flight;
import com.fitap.amadeus.repository.FlightRepository;
import com.fitap.amadeus.util.FlightList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CronJob {

    private final FlightRepository flightRepository;


    @Value("${job.api.url}")
    private String url;

    @Scheduled(cron = "0 4 * * * *") //Every day at 4am
    public void getFlightData() {
        RestTemplate restTemplate = new RestTemplate();
        flightRepository.deleteAll();
        FlightList response = restTemplate.getForObject(
                url,
                FlightList.class);
        List<Flight> flights = response.getFlights();
        flightRepository.deleteAll();
        flightRepository.saveAll(flights);
    }
}
