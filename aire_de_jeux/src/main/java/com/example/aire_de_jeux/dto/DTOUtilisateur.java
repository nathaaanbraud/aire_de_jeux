package com.example.aire_de_jeux.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) pour représenter un utilisateur.
 * Cette classe est utilisée pour transférer les données liées à un utilisateur
 * entre les couches de l'application (contrôleur, service, etc.).
 */
@Getter
@Setter
@NoArgsConstructor
public class DTOUtilisateur {

    /**
     * Identifiant unique de l'utilisateur.
     */
    private Integer id;

    /**
     * Nom de l'utilisateur
     */

    private String nom;
    /**
     * Prénom de l'utilisateur
     */

    private String prenom;
    /**
     * Adresse mail de l'utilisateur
     */

    private String mail;
    /**
     * Nom d'utilisateur (pseudo) de l'utilisateur
     */

    private String username;

    /**
     * Mot de passe de l'utilisateur
     * 2 options :
     *     - Soit on laisse l'attribut mdp (notre choix) tout en faisant en sorte que lors de l'échange service vers dto,
     *     on envoie un mdp null
     *     - Soit on crée une deuxiemes DTO qui ne contiendrait pas d'attribut mdp
     */
    private String password;
}
