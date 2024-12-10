package com.example.aire_de_jeux.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) pour représenter un jeu.
 * Cette classe est utilisée pour transférer les données liées à un jeu
 * entre les couches de l'application (contrôleur, service, etc.).
 */
@Getter
@Setter
@NoArgsConstructor
public class DTOJeux {

    /**
     * Identifiant unique de l'aire de jeu.
     */
    private Integer id;

    /**
     * Nom du jeu.
     */
    private String nom;

    /**
     * Quantité disponible du jeu.
     */
    private Integer quantite;

    /**
     * Description détaillée du jeu.
     */
    private String description;

    /**
     * Localisation géographique ou point d'accès pour le jeu.
     * Peut inclure des informations comme une adresse ou des coordonnées.
     */
    private String pointGeo;
}





