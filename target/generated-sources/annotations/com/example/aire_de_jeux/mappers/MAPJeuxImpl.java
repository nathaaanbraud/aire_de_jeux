package com.example.aire_de_jeux.mappers;

import com.example.aire_de_jeux.dto.DTOJeux;
import com.example.aire_de_jeux.entities.Jeux;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class MAPJeuxImpl implements MAPJeux {

    @Override
    public DTOJeux toDTO(Jeux jeux) {
        if ( jeux == null ) {
            return null;
        }

        DTOJeux dTOJeux = new DTOJeux();

        dTOJeux.setId( jeux.getId() );
        dTOJeux.setNom( jeux.getNom() );
        dTOJeux.setQuantite( jeux.getQuantite() );
        dTOJeux.setDescription( jeux.getDescription() );
        dTOJeux.setPointGeo( jeux.getPointGeo() );

        return dTOJeux;
    }

    @Override
    public Jeux toEntity(DTOJeux dtoJeux) {
        if ( dtoJeux == null ) {
            return null;
        }

        Jeux jeux = new Jeux();

        jeux.setId( dtoJeux.getId() );
        jeux.setNom( dtoJeux.getNom() );
        jeux.setQuantite( dtoJeux.getQuantite() );
        jeux.setDescription( dtoJeux.getDescription() );
        jeux.setPointGeo( dtoJeux.getPointGeo() );

        return jeux;
    }
}
