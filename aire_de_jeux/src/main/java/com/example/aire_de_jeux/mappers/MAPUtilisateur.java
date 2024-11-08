package com.example.aire_de_jeux.mappers;

import com.example.aire_de_jeux.dto.DTOUtilisateur;
import com.example.aire_de_jeux.entities.Utilisateur;
import org.mapstruct.Mapper;

@Mapper
public interface MAPUtilisateur {
    DTOUtilisateur toDTO(Utilisateur utilisateur);
    Utilisateur toEntity(DTOUtilisateur dtoUtilisateur);
}