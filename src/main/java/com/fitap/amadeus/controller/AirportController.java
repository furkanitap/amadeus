package com.fitap.amadeus.controller;

import com.fitap.amadeus.model.Airport;
import com.fitap.amadeus.repository.AirportRepository;
import com.fitap.amadeus.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/airport")
public class AirportController {

    private final AirportService airportService;

    @GetMapping
    public List<Airport> all(Long id){
        return airportService.getAll();
    }

    @GetMapping("/{id}")
    public Airport byId(Long id){
        return airportService.getById(id);
    }

    @PostMapping
    public void save(@RequestBody Airport airport){
        airportService.save(airport);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Airport airport, @PathVariable Long id){
        airportService.updateEmployee(airport, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        airportService.deleteEmployee(id);
    }

}
