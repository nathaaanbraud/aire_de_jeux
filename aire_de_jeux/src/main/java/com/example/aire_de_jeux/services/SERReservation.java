package com.example.aire_de_jeux.services;

import com.example.aire_de_jeux.dto.DTOReservation;
import com.example.aire_de_jeux.entities.Reservation;
import com.example.aire_de_jeux.entities.ReservationId;
import com.example.aire_de_jeux.mappers.MAPReservation;
import com.example.aire_de_jeux.repositories.REPReservation;
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

    // Création d'une nouvelle réservation
    public DTOReservation createReservation(DTOReservation dtoReservation) {
        Reservation reservation = mapReservation.toEntity(dtoReservation);
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
    public Optional<DTOReservation> updateReservation(ReservationId id, DTOReservation dtoReservation) {
        if (repReservation.existsById(id)) {
            Reservation reservationToUpdate = mapReservation.toEntity(dtoReservation);
            reservationToUpdate.setId(id);
            Reservation updatedReservation = repReservation.save(reservationToUpdate);
            return Optional.of(mapReservation.toDTO(updatedReservation));
        }
        return Optional.empty();
    }

    // Suppression
    public boolean deleteReservation(ReservationId id) {
        if (repReservation.existsById(id)) {
            repReservation.deleteById(id);
            return true;
        }
        return false;
    }
}
