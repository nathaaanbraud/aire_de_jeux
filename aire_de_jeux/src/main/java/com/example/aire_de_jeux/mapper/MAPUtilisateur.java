package com.example.aire_de_jeux.mapper;

import com.example.aire_de_jeux.dto.DTOUtilisateur;
import com.example.aire_de_jeux.models.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MAPUtilisateur {
    MAPUtilisateur INSTANCE = Mappers.getMapper(MAPUtilisateur.class);
    DTOUtilisateur toDTO(Utilisateur utilisateur);
    Utilisateur toEntity(DTOUtilisateur dtoUtilisateur);
}