package com.example.aire_de_jeux.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entité représentant une réservation de aire de jeu par un utilisateur.
 * Cette classe est utilisée pour mapper la table `reservation` dans la base de données.
 * Elle gère la relation entre un utilisateur, un jeu et la quantité réservée.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "reservation")
public class Reservation {

    /**
     * Identifiant composite de la réservation, composé des IDs de l'utilisateur et de l'aire de jeu.
     */
    @EmbeddedId
    private ReservationId id;

    /**
     * Quantité de aires de jeux réservés.
     * Indique combien d'exemplaires d'aire de jeu sont réservés par l'utilisateur.
     */
    @Column(nullable = false)
    private Integer reservation;

    /**
     * Clé étrangère vers l'entité Utilisateur.
     * L'utilisateur qui a effectué la réservation.
     */
    @ManyToOne
    @MapsId("utilisateurId")  // L'ID utilisateur est associé à la clé composite de ReservationId
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    /**
     * Clé étrangère vers l'entité Jeux.
     * Le jeu qui a été réservé par l'utilisateur.
     */
    @ManyToOne
    @MapsId("jeuxId")  // L'ID jeu est associé à la clé composite de ReservationId
    @JoinColumn(name = "jeux_id")
    private Jeux jeux;
}
