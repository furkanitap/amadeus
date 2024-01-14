package com.fitap.amadeus.controller;

import com.fitap.amadeus.model.Airport;
import com.fitap.amadeus.model.Flight;
import com.fitap.amadeus.service.AirportService;
import com.fitap.amadeus.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/flight")
public class FlightController {

    private final FlightService flightService;

    @GetMapping("/{id}")
    public Flight byId(Long id){
        return flightService.getById(id);
    }

    @GetMapping
    public List<Flight> all(Long id){
        return flightService.getAll();
    }

    @PostMapping
    public void save(@RequestBody Flight flight){
        flightService.save(flight);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Flight flight, @PathVariable Long id){
        flightService.updateFlight(flight, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        flightService.deleteFlight(id);
    }

    @PostMapping(value = "/find", params = {"departure", "destination", "departureDate"})
    public Flight findFlight(@RequestParam("departure") String departure, @RequestParam("destination") String destination,
                                    @RequestParam("departureDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date departureDate){
        return flightService.findFlight(departure, destination, departureDate);
    }

    @PostMapping(value = "/find", params = {"departure", "destination", "departureDate", "returnDate"})
    public List<Flight> findFlight(@RequestParam("departure") String departure, @RequestParam("destination") String destination,
                             @RequestParam("departureDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date departureDate,
                             @RequestParam("returnDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date returnDate){
        return flightService.findFlight(departure, destination, departureDate, returnDate);
    }



}
