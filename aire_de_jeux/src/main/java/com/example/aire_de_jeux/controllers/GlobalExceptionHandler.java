package com.example.aire_de_jeux.controllers;

import com.example.aire_de_jeux.errors.APIError;
import com.example.aire_de_jeux.errors.ReservationCapacityException;
import com.example.aire_de_jeux.errors.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Gestion des exceptions spécifiques (exemple : ResourceNotFoundException)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIError> handleResourceNotFound(ResourceNotFoundException ex, HttpServletRequest request) {
        System.out.println("Exception capturée dans GlobalExceptionHandler : " + ex.getMessage());
        APIError error = new APIError(
                HttpStatus.NOT_FOUND.value(),
                "Resource Not Found: " + ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<APIError> handleIllegalArgument(IllegalArgumentException ex, HttpServletRequest request) {
        APIError error = new APIError(
                HttpStatus.BAD_REQUEST.value(),
                "Illegal Argument: " + ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ReservationCapacityException.class)
    public ResponseEntity<APIError> handleReservationCapacityException(ReservationCapacityException ex, HttpServletRequest request) {
        APIError error = new APIError(
                HttpStatus.BAD_REQUEST.value(),
                "Capacity issue: " + ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIError> handleGeneralException(Exception ex, HttpServletRequest request) {
        APIError error = new APIError(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error: " + ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}