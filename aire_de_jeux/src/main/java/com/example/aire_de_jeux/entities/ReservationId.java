package com.example.aire_de_jeux.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Clé primaire composite pour l'entité `Reservation`.
 * Contient les identifiants de l'utilisateur et du jeu.
 */
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class ReservationId implements Serializable {

    /**
     * Identifiant de l'utilisateur.
     * Ne peut pas être nul.
     */
    @Column(nullable = false)
    private Integer utilisateurId;

    /**
     * Identifiant du jeu ( aire de jeu).
     * Ne peut pas être nul.
     */
    @Column(nullable = false)
    private Integer jeuxId;
}
