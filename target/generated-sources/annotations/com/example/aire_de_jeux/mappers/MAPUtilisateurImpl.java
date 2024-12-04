package com.example.aire_de_jeux.mappers;

import com.example.aire_de_jeux.dto.DTOUtilisateur;
import com.example.aire_de_jeux.entities.Utilisateur;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class MAPUtilisateurImpl implements MAPUtilisateur {

    @Override
    public DTOUtilisateur toDTO(Utilisateur utilisateur) {
        if ( utilisateur == null ) {
            return null;
        }

        DTOUtilisateur dTOUtilisateur = new DTOUtilisateur();

        dTOUtilisateur.setId( utilisateur.getId() );
        dTOUtilisateur.setNom( utilisateur.getNom() );
        dTOUtilisateur.setPrenom( utilisateur.getPrenom() );
        dTOUtilisateur.setMail( utilisateur.getMail() );
        dTOUtilisateur.setUsername( utilisateur.getUsername() );
        dTOUtilisateur.setPassword( utilisateur.getPassword() );

        return dTOUtilisateur;
    }

    @Override
    public Utilisateur toEntity(DTOUtilisateur dtoUtilisateur) {
        if ( dtoUtilisateur == null ) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setId( dtoUtilisateur.getId() );
        utilisateur.setNom( dtoUtilisateur.getNom() );
        utilisateur.setPrenom( dtoUtilisateur.getPrenom() );
        utilisateur.setMail( dtoUtilisateur.getMail() );
        utilisateur.setPassword( dtoUtilisateur.getPassword() );
        utilisateur.setUsername( dtoUtilisateur.getUsername() );

        return utilisateur;
    }
}
