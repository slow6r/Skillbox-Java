package com.skillbox.airport;

import java.util.Date;
import java.util.List;

public class Flight {
    public enum Type {
        ARRIVAL,
        DEPARTURE
    }

    private Type type;
    private Date date;
    private List<Aircraft> aircraft;

    public Flight(Type type, Date date, List<Aircraft> aircraft) {
        this.type = type;
        this.date = date;
        this.aircraft = aircraft;
    }

    public Type getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public List<Aircraft> getAircraft() {
        return aircraft;
    }
} 