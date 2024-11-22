package com.example.aire_de_jeux.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.C;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class ReservationId implements Serializable {

    @Column(nullable = false)
    private Integer utilisateurId;

    @Column (nullable = false)
    private Integer jeuxId;



}
