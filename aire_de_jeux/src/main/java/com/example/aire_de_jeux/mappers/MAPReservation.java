package com.example.aire_de_jeux.mappers;

import com.example.aire_de_jeux.dto.DTOReservation;
import com.example.aire_de_jeux.entities.Reservation;
import com.example.aire_de_jeux.entities.ReservationId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import com.example.aire_de_jeux.services.SERJeux;
import com.example.aire_de_jeux.services.SERUtilisateur;
import com.example.aire_de_jeux.entities.Jeux;
import com.example.aire_de_jeux.entities.Utilisateur;
import com.example.aire_de_jeux.repositories.REPJeux;
import com.example.aire_de_jeux.repositories.REPUtilisateur;

import java.util.stream.Collectors;

@Mapper
public interface MAPReservation {
    @Mapping(source = "id.utilisateurId", target = "utilisateurId")
    @Mapping(source = "id.jeuxId", target = "jeuxId")
    DTOReservation toDTO(Reservation reservation);

    public default Reservation toEntity(DTOReservation dtoReservation, Jeux jeux, Utilisateur utilisateur) {
        if (dtoReservation == null) {
            return null;
        }
        ReservationId reservationId = new ReservationId(dtoReservation.getUtilisateurId(), dtoReservation.getJeuxId());

        Reservation reservation = new Reservation();
        reservation.setId(reservationId);
        reservation.setReservation(dtoReservation.getReservation());
        reservation.setJeux(jeux);
        reservation.setUtilisateur(utilisateur);

        return reservation;
    }
}
