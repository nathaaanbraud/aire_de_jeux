package com.example.aire_de_jeux.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DTOReservation {

    private Integer utilisateurId;
    private Integer jeuxId;
    private Integer reservation;
}
