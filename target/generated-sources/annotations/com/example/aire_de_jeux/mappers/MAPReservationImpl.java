package com.example.aire_de_jeux.mappers;

import com.example.aire_de_jeux.dto.DTOReservation;
import com.example.aire_de_jeux.entities.Reservation;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class MAPReservationImpl implements MAPReservation {

    @Override
    public DTOReservation toDTO(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        DTOReservation dTOReservation = new DTOReservation();

        dTOReservation.setReservation( reservation.getReservation() );

        return dTOReservation;
    }

    @Override
    public Reservation toEntity(DTOReservation dtoReservation) {
        if ( dtoReservation == null ) {
            return null;
        }

        Reservation reservation = new Reservation();

        reservation.setReservation( dtoReservation.getReservation() );

        return reservation;
    }
}
