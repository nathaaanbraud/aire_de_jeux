package com.example.aire_de_jeux.services;

import com.example.aire_de_jeux.dto.DTOReservation;
import com.example.aire_de_jeux.entities.Jeux;
import com.example.aire_de_jeux.entities.Reservation;
import com.example.aire_de_jeux.entities.ReservationId;
import com.example.aire_de_jeux.entities.Utilisateur;
import com.example.aire_de_jeux.mappers.MAPReservation;
import com.example.aire_de_jeux.repositories.REPJeux;
import com.example.aire_de_jeux.repositories.REPReservation;
import com.example.aire_de_jeux.repositories.REPUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    // Création d'une nouvelle réservation
    public DTOReservation createReservation(DTOReservation dtoReservation) {
        Jeux jeux= repJeux.findById(dtoReservation.getJeuxId()).orElse(null);
        Utilisateur utilisateur = repUtilisateur.findById(dtoReservation.getUtilisateurId()).orElse(null);
        if (jeux == null || utilisateur == null) {
            throw new IllegalArgumentException("ID utilisateur ou ID jeux invalide");
        }
        else if (repReservation.existsByUtilisateurIdAndJeuxId(dtoReservation.getUtilisateurId(), dtoReservation.getJeuxId())) {
            throw new IllegalArgumentException("La réservation existe déjà, veuillez utiliser la mise à jour");
        }
        Reservation reservation = mapReservation.toEntity(dtoReservation, jeux, utilisateur);
        Reservation savedReservation = repReservation.save(reservation);
        return mapReservation.toDTO(savedReservation);
    }

    // Récupération d'une réservation par son ID composite
    public Optional<DTOReservation> getReservationById(ReservationId id) {
        return repReservation.findById(id).map(mapReservation::toDTO);
    }

    //Récupération de toutes les reservations correspondantes à un utilisateur
    public List<DTOReservation> getReservationByUtilisateur(Integer id) {
        return repReservation.findByUtilisateurId(id).stream()
                .map(mapReservation::toDTO)
                .collect(Collectors.toList());
    }

    public List <DTOReservation> getReservationByJeux(Integer id) {
        return repReservation.findByJeuxId(id).stream()
                .map(mapReservation::toDTO)
                .collect(Collectors.toList());
    }

    // Récupération de toutes les réservations
    public List<DTOReservation> getAllReservations() {
        return repReservation.findAll().stream()
                .map(mapReservation::toDTO)
                .collect(Collectors.toList());
    }

    // Mise à jour d'une réservation
    public Optional<DTOReservation> updateReservation(int reservation, DTOReservation dtoReservation) {
        ReservationId reservationId = new ReservationId(dtoReservation.getUtilisateurId(), dtoReservation.getJeuxId());
        Optional<Reservation> existingReservationOpt = repReservation.findById(reservationId);
        if (existingReservationOpt.isEmpty()) {
            throw new IllegalArgumentException("La réservation n'existe pas");
        }
        Reservation existingReservation = existingReservationOpt.get();
        existingReservation.setReservation(reservation);
        Reservation updatedReservation = repReservation.save(existingReservation);
        return Optional.of(mapReservation.toDTO(updatedReservation));

    }

    // Suppression
    public boolean deleteReservation(int utilisateurId, int jeuxId) {
        ReservationId id = new ReservationId(utilisateurId, jeuxId);
        if (repReservation.existsById(id)) {
            repReservation.deleteById(id);
            return true;
        }
        return false;
    }

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
