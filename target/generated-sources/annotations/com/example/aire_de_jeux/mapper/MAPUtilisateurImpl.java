package com.example.aire_de_jeux.mapper;

import com.example.aire_de_jeux.dto.DTOUtilisateurCreation;
import com.example.aire_de_jeux.models.Utilisateur;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-18T14:19:43+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
public class MAPUtilisateurImpl implements MAPUtilisateur {

    @Override
    public DTOUtilisateurCreation toDTO(Utilisateur utilisateur) {
        if ( utilisateur == null ) {
            return null;
        }

        DTOUtilisateurCreation dTOUtilisateurCreation = new DTOUtilisateurCreation();

        return dTOUtilisateurCreation;
    }

    @Override
    public Utilisateur toEntity(DTOUtilisateurCreation dtoUtilisateurCreation) {
        if ( dtoUtilisateurCreation == null ) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();

        return utilisateur;
    }
}
