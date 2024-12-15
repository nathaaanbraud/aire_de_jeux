package com.example.aire_de_jeux.errors;

import lombok.*;
import java.time.LocalDateTime;

/**
 * Représente une erreur de l'API REST.
 * Cette classe est utilisée pour renvoyer des erreurs lorsqu'une exception est interceptée.
 */
@Getter
@Setter
@ToString
public class APIError {

    /**
     * Code d'erreur HTTP.
     */
    private int status;

    /**
     * Message d'erreur.
     */
    private String error;

    /**
     * Horodatage de l'erreur.
     */
    private LocalDateTime timestamp;

    /**
     * Constructeur par défaut.
     *
     * @param status le code d'erreur HTTP
     *               (par exemple, 404 pour NOT FOUND, 500 pour INTERNAL SERVER ERROR, etc.)
     * @param error le message d'erreur
     *              (par exemple, "Resource Not Found", "Internal Server Error", etc.)
     * @param timestamp l'horodatage de l'erreur
     */
    public APIError (int status, String error, LocalDateTime timestamp) {
        this.status = status;
        this.error = error;
        this.timestamp = timestamp;
    }
}

