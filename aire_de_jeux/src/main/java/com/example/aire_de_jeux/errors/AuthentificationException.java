package com.example.aire_de_jeux.errors;

/**
 * Exception lancée lorsqu'une erreur d'authentification se produit.
 */
public class AuthentificationException extends RuntimeException {
    public AuthentificationException(String message) {
        super(message);
    }
}
