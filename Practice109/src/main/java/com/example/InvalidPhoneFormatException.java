package com.example;

public class InvalidPhoneFormatException extends RuntimeException {
    public InvalidPhoneFormatException(String message) {
        super(message);
    }
} 