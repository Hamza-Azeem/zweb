package com.Zweb.backend.advice;

import com.Zweb.backend.exception.DuplicateResourceException;
import com.Zweb.backend.exception.Error;
import com.Zweb.backend.exception.InvalidCredentialsException;
import com.Zweb.backend.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;

import java.util.Map;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Error> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Error error = new Error(ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<Error> handleDuplicateResourceException(DuplicateResourceException ex) {
        Error error = new Error(ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<Error> handleInvalidCredentialsException(InvalidCredentialsException ex) {
        Error error = new Error(ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String field = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(field, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
