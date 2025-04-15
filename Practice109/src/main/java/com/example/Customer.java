package com.example;

public class Customer {
    private final String name;
    private final String phone;
    private final String email;

    public Customer(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Клиент: %s, Телефон: %s, Email: %s", name, phone, email);
    }
} 