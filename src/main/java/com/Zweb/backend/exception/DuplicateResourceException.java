package com.Zweb.backend.exception;

public class DuplicateResourceException extends IllegalArgumentException{
    public DuplicateResourceException(String message) {
        super(message);
    }
}
