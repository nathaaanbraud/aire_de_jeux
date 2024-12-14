package com.example.aire_de_jeux.errors;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class APIError {
    private int status;
    private String error;
    private LocalDateTime timestamp;

    public APIError (int status, String error, LocalDateTime timestamp) {
        this.status = status;
        this.error = error;
        this.timestamp = timestamp;
    }
}

