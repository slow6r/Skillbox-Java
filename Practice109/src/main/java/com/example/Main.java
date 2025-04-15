package com.example;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final CustomerStorage storage = new CustomerStorage();

    public static void main(String[] args) {
        logger.info("Программа запущена");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();
            logger.info("Введена команда: {}", command);

            if (command.equals("help")) {
                printHelp();
            } else if (command.equals("list")) {
                listCustomers();
            } else if (command.startsWith("add ")) {
                addCustomer(command.substring(4));
            } else if (command.equals("exit")) {
                logger.info("Программа завершена");
                return;
            } else {
                System.out.println("Неверная команда");
            }
        }
    }

    private static void printHelp() {
        System.out.println("Список команд:");
        System.out.println("help - показать список команд");
        System.out.println("add Имя Фамилия email@example.com +79999999999 - добавить клиента");
        System.out.println("list - показать список клиентов");
        System.out.println("exit - выход");
    }

    private static void listCustomers() {
        storage.getStorage().values().forEach(customer -> System.out.println(customer.toString()));
    }

    private static void addCustomer(String data) {
        try {
            storage.addCustomer(data);
            System.out.println("Клиент добавлен");
        } catch (RuntimeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
} 