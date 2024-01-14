package com.fitap.amadeus.repository;

import com.fitap.amadeus.model.Airport;
import com.fitap.amadeus.model.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {

    Optional<Flight> getById(Long id);

    Flight getFlightByDepartureAndDestinationAndAndDepartureDate(Airport departure, Airport destination, Date departureDate);

    boolean existsById(Long id);

}
