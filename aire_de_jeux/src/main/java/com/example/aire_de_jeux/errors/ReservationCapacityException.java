package com.example.aire_de_jeux.errors;

public class ReservationCapacityException extends RuntimeException {
    public ReservationCapacityException(String message) {
        super(message);
    }
}
