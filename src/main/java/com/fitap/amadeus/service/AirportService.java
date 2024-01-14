package com.fitap.amadeus.service;


import com.fitap.amadeus.model.Airport;
import com.fitap.amadeus.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;
    public Airport getById(Long id) {
        return airportRepository.getById(id);
    }

    public void save(Airport airport){
        airportRepository.save(airport);
    }

    public List<Airport> getAll() {
        List<Airport> airports = new ArrayList<>();
        airportRepository.findAll().forEach(airports::add);
        return airports;
    }

    public void updateEmployee(Airport airport, Long id) {
        Airport temp = airportRepository.getById(id);
        if(temp != null){
            temp.setCity(airport.getCity());
            airportRepository.save(temp);
        }else{
            airport.setId(id);
            airportRepository.save(airport);
        }
    }

    public void deleteEmployee(Long id){
        airportRepository.deleteById(id);
    }
}
