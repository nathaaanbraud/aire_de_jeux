package com.example.aire_de_jeux.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) pour représenter les informations de connexion.
 * Cette classe est utilisée pour transférer les données liées à la connexion
 * entre les couches de l'application (par exemple, contrôleur, service, etc.).
 */
@Getter
@Setter
@NoArgsConstructor
public class DTOLogin {

    /**
     * Adresse email de l'utilisateur.
     */
    private String mail;

    /**
     * Mot de passe de l'utilisateur.
     */
    private String password;
}
