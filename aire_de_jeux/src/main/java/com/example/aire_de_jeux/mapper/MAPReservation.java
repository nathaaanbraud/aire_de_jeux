package com.example.aire_de_jeux.mapper;
import com.example.aire_de_jeux.dto.DTOReservation;
import com.example.aire_de_jeux.models.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MAPReservation {
    MAPReservation INSTANCE = Mappers.getMapper(MAPReservation.class);
    DTOReservation toDTO(Reservation reservation);
    Reservation toEntity(DTOReservation dtoReservation);
}
