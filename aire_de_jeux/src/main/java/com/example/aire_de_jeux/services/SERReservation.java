package com.example.aire_de_jeux.services;

import com.example.aire_de_jeux.dto.DTOReservation;
import com.example.aire_de_jeux.entities.Jeux;
import com.example.aire_de_jeux.entities.Reservation;
import com.example.aire_de_jeux.entities.ReservationId;
import com.example.aire_de_jeux.entities.Utilisateur;
import com.example.aire_de_jeux.errors.ReservationCapacityException;
import com.example.aire_de_jeux.mappers.MAPReservation;
import com.example.aire_de_jeux.repositories.REPJeux;
import com.example.aire_de_jeux.repositories.REPReservation;
import com.example.aire_de_jeux.repositories.REPUtilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service pour gérer les opérations liées aux réservations.
 */
@Service
public class SERReservation {

    @Autowired
    private REPReservation repReservation;

    @Autowired
    private MAPReservation mapReservation;

    @Autowired
    private REPJeux repJeux;

    @Autowired
    private REPUtilisateur repUtilisateur;

    /**
     * Crée une nouvelle réservation.
     *
     * @param dtoReservation Les données de la réservation encapsulées dans un DTO.
     * @return Le DTO de la réservation créée.
     * @throws IllegalArgumentException Si les IDs utilisateur ou jeux sont invalides,
     *                                  si la réservation existe déjà,
     *                                  ou si la quantité de réservation dépasse la quantité totale disponible.
     */
    public DTOReservation createReservation(DTOReservation dtoReservation) {
        Jeux jeux = repJeux.findById(dtoReservation.getJeuxId()).orElse(null);
        Utilisateur utilisateur = repUtilisateur.findById(dtoReservation.getUtilisateurId()).orElse(null);
        if (jeux == null || utilisateur == null) {
            throw new IllegalArgumentException("ID utilisateur ou ID jeux invalide");
        } else if (repReservation.existsByUtilisateurIdAndJeuxId(dtoReservation.getUtilisateurId(), dtoReservation.getJeuxId())) {
            throw new IllegalArgumentException("La réservation existe déjà, veuillez utiliser la mise à jour");
        } else {
            int nbReservations = repReservation.findByJeuxId(dtoReservation.getJeuxId()).stream()
                    .mapToInt(Reservation::getReservation)
                    .sum();
            if (nbReservations + dtoReservation.getReservation() > jeux.getQuantite()) {
                throw new ReservationCapacityException("La quantité de réservations dépasse la quantité totale du jeu");
            }
        }
        Reservation reservation = mapReservation.toEntity(dtoReservation, jeux, utilisateur);
        Reservation savedReservation = repReservation.save(reservation);
        return mapReservation.toDTO(savedReservation);
    }

    /**
     * Récupère une réservation par son ID composite.
     *
     * @param id L'ID composite de la réservation (utilisateur et jeux).
     * @return Un Optional contenant le DTO de la réservation, ou vide si elle n'existe pas.
     */
    public Optional<DTOReservation> getReservationById(ReservationId id) {
        return repReservation.findById(id).map(mapReservation::toDTO);
    }

    /**
     * Récupère toutes les réservations d'un utilisateur donné.
     *
     * @param id L'identifiant de l'utilisateur.
     * @return Une liste de DTO des réservations associées à l'utilisateur.
     */
    public List<DTOReservation> getReservationByUtilisateur(Integer id) {
        return repReservation.findByUtilisateurId(id).stream()
                .map(mapReservation::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Récupère toutes les réservations associées à un jeu donné.
     *
     * @param id L'identifiant du jeu.
     * @return Une liste de DTO des réservations pour ce jeu.
     */
    public List<DTOReservation> getReservationByJeux(Integer id) {
        return repReservation.findByJeuxId(id).stream()
                .map(mapReservation::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Récupère toutes les réservations.
     *
     * @return Une liste de DTO contenant toutes les réservations.
     */
    public List<DTOReservation> getAllReservations() {
        return repReservation.findAll().stream()
                .map(mapReservation::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Met à jour une réservation existante.
     *
     * @param dtoReservation Les nouvelles données de la réservation encapsulées dans un DTO.
     * @return Un Optional contenant le DTO de la réservation mise à jour, ou vide si elle n'existe pas.
     * @throws IllegalArgumentException Si la réservation n'existe pas.
     */
    public Optional<DTOReservation> updateReservation(DTOReservation dtoReservation) {
        ReservationId reservationId = new ReservationId(dtoReservation.getUtilisateurId(), dtoReservation.getJeuxId());
        Optional<Reservation> existingReservationOpt = repReservation.findById(reservationId);
        if (existingReservationOpt.isEmpty()) {
            throw new IllegalArgumentException("La réservation n'existe pas");
        }
        Reservation existingReservation = existingReservationOpt.get();
        existingReservation.setReservation(dtoReservation.getReservation());
        Reservation updatedReservation = repReservation.save(existingReservation);
        return Optional.of(mapReservation.toDTO(updatedReservation));
    }

    /**
     * Supprime une réservation par son ID composite.
     *
     * @param utilisateurId L'identifiant de l'utilisateur.
     * @param jeuxId        L'identifiant du jeu.
     * @return true si la réservation a été supprimée, false sinon.
     */
    public boolean deleteReservation(int utilisateurId, int jeuxId) {
        ReservationId id = new ReservationId(utilisateurId, jeuxId);
        if (repReservation.existsById(id)) {
            repReservation.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Met à jour le nombre de réservations pour une réservation existante.
     *
     * @param nbReservations Le nombre de réservations à ajouter.
     * @param dtoReservation Les données de la réservation à mettre à jour.
     * @return Un Optional contenant le DTO de la réservation mise à jour, ou vide si elle n'existe pas.
     * @throws IllegalArgumentException Si la réservation n'existe pas.
     */
    public Optional<DTOReservation> updateNbReservation(int nbReservations, DTOReservation dtoReservation) {
        ReservationId reservationId = new ReservationId(dtoReservation.getUtilisateurId(), dtoReservation.getJeuxId());
        Optional<Reservation> existingReservationOpt = repReservation.findById(reservationId);
        if (existingReservationOpt.isEmpty()) {
            throw new IllegalArgumentException("La réservation n'existe pas");
        }
        Reservation existingReservation = existingReservationOpt.get();
        existingReservation.setReservation(existingReservation.getReservation() + nbReservations);
        Reservation updatedReservation = repReservation.save(existingReservation);
        return Optional.of(mapReservation.toDTO(updatedReservation));
    }
}
