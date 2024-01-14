package com.fitap.amadeus.repository;


import com.fitap.amadeus.model.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Long> {

    Airport getById(Long id);

    Airport getByCity(String city);
}
