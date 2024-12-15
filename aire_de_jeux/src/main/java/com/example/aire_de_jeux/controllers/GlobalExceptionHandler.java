package com.example.aire_de_jeux.controllers;

import com.example.aire_de_jeux.errors.APIError;
import com.example.aire_de_jeux.errors.AuthentificationException;
import com.example.aire_de_jeux.errors.ReservationCapacityException;
import com.example.aire_de_jeux.errors.ResourceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * Gestionnaire des exceptions globales pour l'API REST.
 * Intercepte les exceptions et renvoie une réponse HTTP appropriée.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Intercepte les exceptions ResourceNotFoundException et renvoie une réponse HTTP appropriée.
     *
     * @param ex l'exception interceptée
     * @param request la requête HTTP
     * @return une réponse HTTP avec le code d'erreur et le message d'erreur
     */
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

    /**
     * Intercepte les exceptions IllegalArgumentException et renvoie une réponse HTTP appropriée.
     *
     * @param ex l'exception interceptée
     * @param request la requête HTTP
     * @return une réponse HTTP avec le code d'erreur et le message d'erreur
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<APIError> handleIllegalArgument(IllegalArgumentException ex, HttpServletRequest request) {
        APIError error = new APIError(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    /**
     * Intercepte les exceptions ReservationCapacityException et renvoie une réponse HTTP appropriée.
     *
     * @param ex l'exception interceptée
     * @param request la requête HTTP
     * @return une réponse HTTP avec le code d'erreur et le message d'erreur
     */
    @ExceptionHandler(ReservationCapacityException.class)
    public ResponseEntity<APIError> handleReservationCapacityException(ReservationCapacityException ex, HttpServletRequest request) {
        APIError error = new APIError(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    /**
     * Intercepte les exceptions AuthentificationException et renvoie une réponse HTTP appropriée.
     *
     * @param ex l'exception interceptée
     * @param request la requête HTTP
     * @return une réponse HTTP avec le code d'erreur et le message d'erreur
     */
    @ExceptionHandler(AuthentificationException.class)
    public ResponseEntity<APIError> handleAuthentificationException(AuthentificationException ex, HttpServletRequest request) {
        APIError error = new APIError(
                HttpStatus.UNAUTHORIZED.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }

    /**
     * Intercepte les exceptions Exception et renvoie une réponse HTTP appropriée.
     *
     * @param ex l'exception interceptée
     * @param request la requête HTTP
     * @return une réponse HTTP avec le code d'erreur et le message d'erreur
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIError> handleGeneralException(Exception ex, HttpServletRequest request) {
        APIError error = new APIError(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}