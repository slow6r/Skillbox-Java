package com.skillbox.airport;

import java.util.List;

public class Terminal {
    private final String name;
    private final List<Flight> flights;
    private final List<Aircraft> parkedAircraft;

    public Terminal(String name, List<Flight> flights, List<Aircraft> parkedAircraft) {
        this.name = name;
        this.flights = flights;
        this.parkedAircraft = parkedAircraft;
    }

    public String getName() {
        return name;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public List<Aircraft> getParkedAircraft() {
        return parkedAircraft;
    }
} 