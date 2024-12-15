package com.example.aire_de_jeux.errors;

/**
 * Exception lancée lorsqu'une réservation dépasse la capacité maximale.
 */
public class ReservationCapacityException extends RuntimeException {
    public ReservationCapacityException(String message) {
        super(message);
    }
}
