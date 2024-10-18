package com.example.aire_de_jeux.mapper;

import com.example.aire_de_jeux.dto.DTOUtilisateurCreation;
import com.example.aire_de_jeux.models.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MAPUtilisateur {
    MAPUtilisateur INSTANCE = Mappers.getMapper(MAPUtilisateur.class);
    DTOUtilisateurCreation toDTO(Utilisateur utilisateur);
    Utilisateur toEntity(DTOUtilisateurCreation dtoUtilisateurCreation);
}