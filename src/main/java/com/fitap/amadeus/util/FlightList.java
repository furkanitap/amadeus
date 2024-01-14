package com.fitap.amadeus.util;

import com.fitap.amadeus.model.Flight;
import jdk.jfr.SettingDefinition;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FlightList {
    private List<Flight> flights;

    public FlightList(){
        flights = new ArrayList<>();
    }
}
