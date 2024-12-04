package com.example.aire_de_jeux.mappers;

import com.example.aire_de_jeux.dto.DTOUtilisateur;
import com.example.aire_de_jeux.entities.Utilisateur;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface MAPUtilisateur {
    DTOUtilisateur toDTO(Utilisateur utilisateur);
    Utilisateur toEntity(DTOUtilisateur dtoUtilisateur);

    @AfterMapping
    default void afterToDTO(@MappingTarget DTOUtilisateur dtoUtilisateur) {
        dtoUtilisateur.setPassword("");
    }
}