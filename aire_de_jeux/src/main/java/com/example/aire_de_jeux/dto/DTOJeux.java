package com.example.aire_de_jeux.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DTOJeux {
    private Integer id;
    private String nom;
    private Integer quantite;
    private String description;
    private String pointGeo;
}
