package com.example.aire_de_jeux.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entité représentant un utilisateur dans le système.
 * Cette classe est mappée à la table `utilisateur` dans la base de données.
 * Elle contient les informations liées à un utilisateur, telles que son nom, prénom,
 * adresse email, mot de passe et nom d'utilisateur.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "utilisateur")
public class Utilisateur {

    /**
     * Identifiant unique de l'utilisateur.
     * Il est généré automatiquement par la base de données.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nom de l'utilisateur.
     * Ne peut pas être nul et sa longueur maximale est de 100 caractères.
     */
    @Column(nullable = false, length = 100)
    private String nom;

    /**
     * Prénom de l'utilisateur.
     * Ne peut pas être nul et sa longueur maximale est de 100 caractères.
     */
    @Column(nullable = false, length = 100)
    private String prenom;

    /**
     * Adresse email de l'utilisateur.
     * Ne peut pas être nul, unique et sa longueur maximale est de 100 caractères.
     */
    @Column(nullable = false, length = 100, unique = true)
    private String mail;

    /**
     * Mot de passe de l'utilisateur.
     * Ne peut pas être nul et sa longueur maximale est de 100 caractères.
     */
    @Column(nullable = false, length = 100)
    private String password;

    /**
     * Nom d'utilisateur de l'utilisateur.
     * Ne peut pas être nul, unique et sa longueur maximale est de 100 caractères.
     */
    @Column(nullable = false, length = 100, unique = true)
    private String username;
}