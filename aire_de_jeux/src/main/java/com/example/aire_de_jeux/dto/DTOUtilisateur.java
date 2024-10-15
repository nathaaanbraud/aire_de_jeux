package com.example.aire_de_jeux.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class DTOUtilisateur {

    private Integer id;
    private String nom;
    private String prenom;
    private String mail;
    private String username;
    // On ne met volontairement pas le mot depasse, pour des enjeux de sécurité.
}
