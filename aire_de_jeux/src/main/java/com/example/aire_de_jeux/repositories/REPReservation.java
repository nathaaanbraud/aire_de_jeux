package com.example.aire_de_jeux.repositories;

import com.example.aire_de_jeux.entities.Reservation;
import com.example.aire_de_jeux.entities.ReservationId;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Interface pour le dépôt des entités `Reservation`.
 * Permet d'effectuer des opérations CRUD sur les entités `Reservation` dans la base de données.
 */
public interface REPReservation extends JpaRepository<Reservation, ReservationId> {

    /**
     * Trouve toutes les réservations d'un utilisateur par son ID.
     *
     * @param utilisateurId l'ID de l'utilisateur.
     * @return une liste de réservations correspondant à l'utilisateur.
     */
    List<Reservation> findByUtilisateurId(Integer utilisateurId);

    /**
     * Trouve toutes les réservations d'un jeu par son ID.
     *
     * @param jeuxId l'ID du jeu.
     * @return une liste de réservations correspondant au jeu.
     */
    List<Reservation> findByJeuxId(Integer jeuxId);

    /**
     * Vérifie si une réservation existe pour un utilisateur et un jeu spécifiques.
     *
     * @param utilisateurId l'ID de l'utilisateur.
     * @param jeuxId l'ID du jeu.
     * @return true si la réservation existe, sinon false.
     */
    boolean existsByUtilisateurIdAndJeuxId(Integer utilisateurId, Integer jeuxId);
}