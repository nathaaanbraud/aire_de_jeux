package com.example.aire_de_jeux.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Table(name = "reservation")
public class Reservation {

    @Id
    @Column(name = "utilisateur_id")
    private Integer utilisateurId;

    @Id
    @Column(name = "jeux_id")
    private Integer jeuxId;

    @Column(nullable = false)
    private Integer reservation;

    // Clé étrangère vers Utilisateur
    @ManyToOne
    @JoinColumn(name = "utilisateur_id", insertable = false, updatable = false)
    private Utilisateur utilisateur;

    // Clé étrangère vers Jeux
    @ManyToOne
    @JoinColumn(name = "jeux_id", insertable = false, updatable = false)
    private Jeux jeux;
}
