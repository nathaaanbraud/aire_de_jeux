package com.example.aire_de_jeux.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "jeux")
public class Jeux {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(nullable = false)
    private Integer quantite;

    @Column(length = 100)
    private String description;

    @Column(name = "point_geo", nullable = false, length = 100)
    private String pointGeo;


}
