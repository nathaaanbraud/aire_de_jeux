package com.example.aire_de_jeux.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DTOUtilisateur {
    private Integer id;
    private String nom;
    private String prenom;
    private String mail;
    private String username;
    // 2 options ; on laisse l'attribut mdp (notre choix) tout en faisant en sorte que lors de l'échange service vers dto, on envoie un mdp null
    // soit on crée une deuxiemes DTO qui ne contiendrait pas d'attribut mdp
    private String password;
}
