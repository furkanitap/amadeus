package com.fitap.amadeus.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private Airport departure;

    @ManyToOne
    private Airport destination;

    @Temporal(TemporalType.DATE)
    private Date departureDate;

    @Temporal(TemporalType.TIME)
    private Date departureTime;

    /*@Temporal(TemporalType.DATE)
    private Date returnDate;

    @Temporal(TemporalType.TIME)
    private Date returnTime;*/

    @Column
    private int price;

    public Flight(Airport departure, Airport destination, Date departureDate, Date departureTime, int price) {
        this.departure = departure;
        this.destination = destination;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.price = price;
    }

    public Flight() {

    }
}
