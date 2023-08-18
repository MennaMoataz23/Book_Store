package com.example.bookStore.exception;

public class BadEntryException extends RuntimeException{
    public BadEntryException(String message) {
        super(message);
    }
}