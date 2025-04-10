package com.skillbox.airport;

import java.util.List;

public class Airport {
    private List<Terminal> terminals;

    public Airport(List<Terminal> terminals) {
        this.terminals = terminals;
    }

    public List<Terminal> getTerminals() {
        return terminals;
    }
} 