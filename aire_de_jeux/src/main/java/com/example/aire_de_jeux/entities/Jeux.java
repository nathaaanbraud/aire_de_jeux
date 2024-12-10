package com.example.aire_de_jeux.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entité représentant une aire de jeu dans le système.
 * Cette classe est utilisée pour mapper la table `jeux` dans la base de données.
 * Elle contient les informations relatives à un jeu, telles que son nom, sa quantité,
 * sa description et sa localisation géographique.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "jeux")
public class Jeux {

    /**
     * Identifiant unique de l'aire de jeu.
     * Il est généré automatiquement par la base de données.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nom de l'aire de jeu.
     * Il ne peut pas être nul et sa longueur maximale est de 100 caractères.
     */
    @Column(nullable = false, length = 100)
    private String nom;

    /**
     * Quantité disponible de l'aire de jeu
     * Il représente le nombre d'exemplaires disponibles dans le système.
     */
    @Column(nullable = false)
    private Integer quantite;

    /**
     * Description de l'aire de jeu.
     * Ce champ est optionnel et sa longueur maximale est de 100 caractères.
     */
    @Column(length = 100)
    private String description;

    /**
     * Localisation géographique ou point d'accès de l'aire de jeu.
     * Il s'agit d'une chaîne de caractères représentant un emplacement,
     * qui ne peut pas être nul et a une longueur maximale de 100 caractères.
     */
    @Column(name = "point_geo", nullable = false, length = 100)
    private String pointGeo;
}