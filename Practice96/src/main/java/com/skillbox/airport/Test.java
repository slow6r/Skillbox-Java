package com.skillbox.airport;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // Создаем самолеты
        List<Aircraft> aircrafts1 = new ArrayList<>();
        aircrafts1.add(new Aircraft("Airbus A320"));
        aircrafts1.add(new Aircraft("Airbus A380"));
        
        List<Aircraft> aircrafts2 = new ArrayList<>();
        aircrafts2.add(new Aircraft("Boeing 737"));
        aircrafts2.add(new Aircraft("Airbus A320"));

        // Создаем рейсы
        List<Flight> flights1 = new ArrayList<>();
        flights1.add(new Flight(Flight.Type.DEPARTURE, 
            Date.from(LocalDateTime.now().plusHours(2).atZone(java.time.ZoneId.systemDefault()).toInstant()),
            aircrafts1));
        
        List<Flight> flights2 = new ArrayList<>();
        flights2.add(new Flight(Flight.Type.ARRIVAL,
            Date.from(LocalDateTime.now().plusHours(1).atZone(java.time.ZoneId.systemDefault()).toInstant()),
            aircrafts2));

        // Создаем терминалы
        List<Terminal> terminals = new ArrayList<>();
        terminals.add(new Terminal("Terminal 1", flights1, aircrafts1));
        terminals.add(new Terminal("Terminal 2", flights2, aircrafts2));

        // Создаем аэропорт
        Airport airport = new Airport(terminals);

        // Тестируем методы
        System.out.println("Количество самолетов Airbus: " + 
            Main.findCountAircraftWithModelAirbus(airport, "Airbus"));
        
        System.out.println("\nКоличество припаркованных самолетов по терминалам:");
        Main.findMapCountParkedAircraftByTerminalName(airport)
            .forEach((terminal, count) -> System.out.println(terminal + ": " + count));
        
        System.out.println("\nРейсы в ближайшие 2 часа:");
        Main.findFlightsLeavingInTheNextHours(airport, 2)
            .forEach(flight -> System.out.println("Рейс: " + flight.getType() + 
                ", Время: " + flight.getDate()));
        
        System.out.println("\nПервый прибывающий рейс в Terminal 1:");
        Main.findFirstFlightArriveToTerminal(airport, "Terminal 1")
            .ifPresent(flight -> System.out.println("Рейс: " + flight.getType() + 
                ", Время: " + flight.getDate()));
    }
} 