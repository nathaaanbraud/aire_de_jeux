package com.example.aire_de_jeux.mappers;

import com.example.aire_de_jeux.dto.DTOReservation;
import com.example.aire_de_jeux.entities.Reservation;
import com.example.aire_de_jeux.entities.ReservationId;
import com.example.aire_de_jeux.entities.Jeux;
import com.example.aire_de_jeux.entities.Utilisateur;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Interface de mappage pour l'entité `Reservation` et son DTO associé `DTOReservation`.
 * Utilise MapStruct pour convertir les entités `Reservation` en `DTOReservation` et inversement.
 */
@Mapper
public interface MAPReservation {

    /**
     * Convertit une entité `Reservation` en un objet `DTOReservation`.
     * Les identifiants `utilisateurId` et `jeuxId` de la clé primaire composite sont extraits de l'objet `ReservationId`.
     *
     * @param reservation l'entité `Reservation` à convertir.
     * @return l'objet `DTOReservation` correspondant à l'entité `Reservation`.
     */
    @Mapping(source = "id.utilisateurId", target = "utilisateurId")
    @Mapping(source = "id.jeuxId", target = "jeuxId")
    DTOReservation toDTO(Reservation reservation);

    /**
     * Convertit un objet `DTOReservation` en une entité `Reservation`.
     * L'entité `Reservation` est créée à partir de l'objet DTO en associant les entités `Jeux` et `Utilisateur`.
     *
     * @param dtoReservation l'objet `DTOReservation` à convertir.
     * @param jeux l'entité `Jeux` associée à la réservation.
     * @param utilisateur l'entité `Utilisateur` associée à la réservation.
     * @return l'entité `Reservation` correspondant à l'objet `DTOReservation`.
     */
    default Reservation toEntity(DTOReservation dtoReservation, Jeux jeux, Utilisateur utilisateur) {
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