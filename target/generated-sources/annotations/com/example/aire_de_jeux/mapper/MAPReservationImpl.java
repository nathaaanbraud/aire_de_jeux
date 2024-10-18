package com.example.aire_de_jeux.mapper;

import com.example.aire_de_jeux.dto.DTOReservation;
import com.example.aire_de_jeux.models.Reservation;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-18T14:19:44+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
public class MAPReservationImpl implements MAPReservation {

    @Override
    public DTOReservation toDTO(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        DTOReservation dTOReservation = new DTOReservation();

        return dTOReservation;
    }

    @Override
    public Reservation toEntity(DTOReservation dtoReservation) {
        if ( dtoReservation == null ) {
            return null;
        }

        Reservation reservation = new Reservation();

        return reservation;
    }
}
