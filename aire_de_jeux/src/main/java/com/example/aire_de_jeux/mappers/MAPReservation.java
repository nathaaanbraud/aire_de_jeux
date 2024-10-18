package com.example.aire_de_jeux.mappers;
import com.example.aire_de_jeux.dto.DTOReservation;
import com.example.aire_de_jeux.entities.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MAPReservation {
    DTOReservation toDTO(Reservation reservation);
    Reservation toEntity(DTOReservation dtoReservation);
}
