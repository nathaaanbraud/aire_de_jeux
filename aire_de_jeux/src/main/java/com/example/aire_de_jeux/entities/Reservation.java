package com.example.aire_de_jeux.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "reservation")
public class Reservation {

    @EmbeddedId
    private ReservationId id;

    @Column(nullable = false)
    private Integer reservation;

    // Clé étrangère vers Utilisateur
    @ManyToOne
    @MapsId("utilisateurId")  // on va associer l'ID utilisateur de ReservationId
    @JoinColumn(name = "utilisateur_id", insertable = false, updatable = false)
    private Utilisateur utilisateur;

    // Clé étrangère vers Jeux
    @ManyToOne
    @MapsId("jeuxId")  // Pareil pour l'ID jeu de ReservationId
    @JoinColumn(name = "jeux_id", insertable = false, updatable = false)
    private Jeux jeux;
}
