package com.fitap.amadeus.service;

import com.fitap.amadeus.model.Airport;
import com.fitap.amadeus.model.Flight;
import com.fitap.amadeus.repository.AirportRepository;
import com.fitap.amadeus.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    private final AirportRepository airportRepository;
    public Flight getById(Long id) {
        return flightRepository.getById(id).get();
    }

    public List<Flight> getAll() {
        List<Flight> flights = new ArrayList<>();
        flightRepository.findAll().forEach(flights::add);
        return flights;
    }

    public void save(Flight flight) {
        flightRepository.save(flight);
    }

    public void updateFlight(Flight flight, Long id) {
        Flight temp = flightRepository.getById(id).get();
        if(temp != null){
            temp.setDeparture(flight.getDeparture());
            temp.setDestination(flight.getDestination());
            temp.setDepartureDate(flight.getDepartureDate());
            temp.setDepartureTime(flight.getDepartureTime());
            temp.setPrice(flight.getPrice());
            flightRepository.save(temp);
        }else{
            flight.setId(id);
            flightRepository.save(flight);
        }
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    public Flight findFlight(String departure, String destination, Date departureDate) {
        Airport dep = airportRepository.getByCity(departure);
        Airport dest = airportRepository.getByCity(destination);
        return flightRepository.getFlightByDepartureAndDestinationAndAndDepartureDate(dep, dest, departureDate);
    }

    public List<Flight> findFlight(String departure, String destination, Date departureDate, Date returnDate) {
        Flight depFlight = findFlight(departure, destination, departureDate);
        Flight returnFlight = findFlight(destination, departure, returnDate);
        return List.of(depFlight, returnFlight);
    }
}
