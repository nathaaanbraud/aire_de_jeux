package com.example.aire_de_jeux.mappers;

import com.example.aire_de_jeux.dto.DTOReservation;
import com.example.aire_de_jeux.entities.Reservation;
import org.mapstruct.Mapper;

@Mapper
public interface MAPReservation {
    DTOReservation toDTO(Reservation reservation);
    Reservation toEntity(DTOReservation dtoReservation);
}
