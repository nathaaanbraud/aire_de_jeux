package com.example.aire_de_jeux.controllers;

import com.example.aire_de_jeux.dto.DTOReservation;
import com.example.aire_de_jeux.entities.ReservationId;
import com.example.aire_de_jeux.errors.ResourceNotFoundException;
import com.example.aire_de_jeux.services.SERReservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Contrôleur pour gérer les opérations liées aux réservations.
 * Fournit des points d'accès API pour créer, lire, mettre à jour et supprimer des réservations.
 */
@RestController
@RequestMapping("/api/reservations")
public class CTRReservation {

    /**
     * Service de gestion des réservations.
     */
    @Autowired
    private SERReservation serReservation;

    /**
     * Crée une nouvelle réservation.
     *
     * @param dtoReservation l'objet DTO contenant les détails de la réservation à créer.
     * @return une réponse HTTP avec la réservation créée (201 Created).
     */
    @PostMapping
    public ResponseEntity<DTOReservation> createReservation(@RequestBody DTOReservation dtoReservation) {
        DTOReservation createdReservation = serReservation.createReservation(dtoReservation);
        return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
    }

    /**
     * Récupère toutes les réservations.
     *
     * @return une liste de toutes les réservations disponibles.
     */
    @GetMapping
    public List<DTOReservation> getAllReservations() {
        return serReservation.getAllReservations();
    }

    /**
     * Récupère une réservation par son ID.
     *
     * @param id l'ID de la réservation à récupérer.
     * @return une réponse HTTP avec la réservation correspondante (200 OK)
     * ou une réponse 404 Not Found si elle n'existe pas.
     */
    @GetMapping("/{id}")
    public ResponseEntity<DTOReservation> getReservationById(@PathVariable ReservationId id) {
        Optional<DTOReservation> reservation = serReservation.getReservationById(id);
        return reservation
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation introuvable"));
    }

    /**
     * Récupère toutes les réservations pour un utilisateur donné.
     *
     * @param utilisateurId l'ID de l'utilisateur.
     * @return une liste des réservations faites par cet utilisateur.
     */
    @GetMapping("/utilisateur/{utilisateurId}")
    public List<DTOReservation> getReservationByUtilisateur(@PathVariable Integer utilisateurId) {
        return serReservation.getReservationByUtilisateur(utilisateurId);
    }

    /**
     * Récupère toutes les réservations pour un jeu donné.
     *
     * @param jeuxId l'ID du jeu.
     * @return une liste des réservations associées à ce jeu.
     */
    @GetMapping("/jeux/{jeuxId}")
    public List<DTOReservation> getReservationByJeux(@PathVariable Integer jeuxId) {
        return serReservation.getReservationByJeux(jeuxId);
    }

    /**
     * Met à jour une réservation existante.
     *
     * @param dtoReservation l'objet DTO contenant les nouvelles informations de la réservation.
     * @return une réponse HTTP avec la réservation mise à jour (200 OK)
     * ou une réponse 404 Not Found si la réservation n'existe pas.
     */
    @PutMapping("/{reservation}")
    public ResponseEntity<DTOReservation> updateReservation(@RequestBody DTOReservation dtoReservation) {
        Optional<DTOReservation> updatedReservation = serReservation.updateReservation(dtoReservation);
        return updatedReservation
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation introuvable"));
    }

    /**
     * Supprime une réservation donnée en fonction de l'utilisateur et du jeu associés.
     *
     * @param utilisateurId l'ID de l'utilisateur associé à la réservation.
     * @param jeuxId        l'ID du jeu associé à la réservation.
     * @return une réponse HTTP 204 No Content si la suppression est réussie,
     * ou 404 Not Found si la réservation n'existe pas.
     */
    @DeleteMapping("/{utilisateurId}/{jeuxId}")
    public ResponseEntity<Void> deleteReservation(@PathVariable int utilisateurId, @PathVariable int jeuxId) {
        boolean isDeleted = serReservation.deleteReservation(utilisateurId, jeuxId);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            throw new ResourceNotFoundException("Reservation introuvable");
        }
    }

    /**
     * Modifie le nombre de réservations (ajout ou suppression de quantité).
     *
     * @param nbReservations le nombre de réservations à ajouter ou à enlever.
     * @param dtoReservation l'objet DTO contenant les détails de la réservation à modifier.
     * @return une réponse HTTP avec la réservation mise à jour (200 OK)
     * ou une réponse 404 Not Found si la réservation n'existe pas.
     */
    @PutMapping("/rajout/{nbReservations}")
    public ResponseEntity<DTOReservation> updateNbReservation(@PathVariable int nbReservations, @RequestBody DTOReservation dtoReservation) {
        Optional<DTOReservation> updatedReservation = serReservation.updateNbReservation(nbReservations, dtoReservation);
        return updatedReservation
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation introuvable"));
    }
}
