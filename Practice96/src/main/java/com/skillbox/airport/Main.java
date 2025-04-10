package com.skillbox.airport;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static long findCountAircraftWithModelAirbus(Airport airport, String model) {
        return airport.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .flatMap(flight -> flight.getAircraft().stream())
                .filter(aircraft -> aircraft.getName().startsWith(model))
                .count();
    }

    public static Map<String, Integer> findMapCountParkedAircraftByTerminalName(Airport airport) {
        return airport.getTerminals().stream()
                .collect(Collectors.groupingBy(
                        Terminal::getName,
                        Collectors.summingInt(terminal -> terminal.getParkedAircraft().size())
                ));
    }

    public static List<Flight> findFlightsLeavingInTheNextHours(Airport airport, int hours) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime end = now.plusHours(hours);

        return airport.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType() == Flight.Type.DEPARTURE)
                .filter(flight -> {
                    LocalDateTime departureTime = flight.getDate().toInstant()
                            .atZone(ZoneId.systemDefault()).toLocalDateTime();
                    return !departureTime.isBefore(now) && !departureTime.isAfter(end);
                })
                .collect(Collectors.toList());
    }

    public static Optional<Flight> findFirstFlightArriveToTerminal(Airport airport, String terminalName) {
        return airport.getTerminals().stream()
                .filter(terminal -> terminal.getName().equals(terminalName))
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType() == Flight.Type.ARRIVAL)
                .min(Comparator.comparing(Flight::getDate));
    }
}