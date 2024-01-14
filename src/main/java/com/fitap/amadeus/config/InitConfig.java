package com.fitap.amadeus.config;

import com.fitap.amadeus.model.Airport;
import com.fitap.amadeus.model.Flight;
import com.fitap.amadeus.model.User;
import com.fitap.amadeus.model.request.SignupRequest;
import com.fitap.amadeus.service.AirportService;
import com.fitap.amadeus.service.FlightService;
import com.fitap.amadeus.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class InitConfig {

    private final UserService userService;

    private final FlightService flightService;

    private final AirportService airportService;

    @Bean
    public CommandLineRunner initRoles() {
        return args -> {


            try {
                final User adminUser = userService.findUserByUsername("admin");
            } catch (Exception e) {
                SignupRequest adminUser = new SignupRequest();
                adminUser.setName("System");
                adminUser.setUsername("admin");
                adminUser.setPassword("admin");
                Airport izmirAirport = new Airport("Izmir");
                Airport ankaraAirport = new Airport("Ankara");
                Airport istanbulAirport = new Airport("Istanbul");

                airportService.save(izmirAirport);
                airportService.save(ankaraAirport);
                airportService.save(istanbulAirport);

                Flight flight1 = new Flight(izmirAirport, ankaraAirport, new SimpleDateFormat("dd-MM-yyyy").parse("02-02-2024"),
                        new SimpleDateFormat("mm:HH").parse("15:15"), 100);
                Flight flight2 = new Flight(ankaraAirport, istanbulAirport, new SimpleDateFormat("dd-MM-yyyy").parse("04-04-2024"),
                        new SimpleDateFormat("mm:HH").parse("15:15"), 200);
                Flight flight3 = new Flight(istanbulAirport, izmirAirport, new SimpleDateFormat("dd-MM-yyyy").parse("06-06-2024"),
                        new SimpleDateFormat("mm:HH").parse("15:15"), 300);
                Flight flight4 = new Flight(izmirAirport, istanbulAirport, new SimpleDateFormat("dd-MM-yyyy").parse("08-08-2024"),
                        new SimpleDateFormat("mm:HH").parse("15:15"), 400);

                flightService.save(flight1);
                flightService.save(flight2);
                flightService.save(flight3);
                flightService.save(flight4);
                //Also some urls:
                //POST for auth: localhost:8080/api/auth/login
                //POST for one-way: localhost:8080/api/flight/find?departure=Istanbul&destination=Izmir&departureDate=06-06-2024
                //POST for two-way: localhost:8080/api/flight/find?departure=Istanbul&destination=Izmir&departureDate=06-06-2024&returnDate=08-08-2024

                userService.createUser(adminUser);
            }
        };
    }
}
