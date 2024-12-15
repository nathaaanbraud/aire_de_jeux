package com.example.aire_de_jeux.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) pour représenter une réservation.
 * Cette classe est utilisée pour transférer les données liées à une réservation
 * entre les couches de l'application (par exemple, contrôleur, service, etc.).
 */
@Getter
@Setter
@NoArgsConstructor
public class DTOReservation {

    /**
     * Identifiant unique de l'utilisateur ayant effectué la réservation.
     */
    private Integer utilisateurId;

    /**
     * Identifiant unique du jeu réservé.
     */
    private Integer jeuxId;

    /**
     * Quantité de réservations effectuées pour ce jeu par l'utilisateur.
     */
    private Integer reservation;
}
