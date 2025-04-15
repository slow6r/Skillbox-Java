package com.example;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomerStorage {
    private static final Logger logger = LogManager.getLogger(CustomerStorage.class);
    private final HashMap<String, Customer> storage = new HashMap<>();

    public void addCustomer(String data) {
        try {
            String[] components = data.split("\\s+", 4);
            if (components.length != 4) {
                throw new IncorrectComponentCountException("Неверное количество данных");
            }

            String name = components[0] + " " + components[1];
            String email = components[2];
            String phone = components[3];

            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                throw new InvalidEmailFormatException("Неверный формат email");
            }

            if (!phone.matches("^\\+\\d{11}$")) {
                throw new InvalidPhoneFormatException("Неверный формат телефона");
            }

            storage.put(name, new Customer(name, phone, email));
            logger.info("Клиент добавлен: {}", name);
        } catch (RuntimeException e) {
            logger.error("Ошибка: {}", e.getMessage());
            throw e;
        }
    }

    public HashMap<String, Customer> getStorage() {
        return storage;
    }
} 