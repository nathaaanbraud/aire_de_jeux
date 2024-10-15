package com.example.aire_de_jeux.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DTOUtilisateurCreation {
    private Integer id;
    private String nom;
    private String prenom;
    private String mail;
    private String username;
    private String password;
}
