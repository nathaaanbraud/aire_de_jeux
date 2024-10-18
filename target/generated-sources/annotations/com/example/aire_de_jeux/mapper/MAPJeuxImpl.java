package com.example.aire_de_jeux.mapper;

import com.example.aire_de_jeux.dto.DTOJeux;
import com.example.aire_de_jeux.models.Jeux;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-18T14:19:44+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
public class MAPJeuxImpl implements MAPJeux {

    @Override
    public DTOJeux toDTO(Jeux jeux) {
        if ( jeux == null ) {
            return null;
        }

        DTOJeux dTOJeux = new DTOJeux();

        return dTOJeux;
    }

    @Override
    public Jeux toEntity(DTOJeux dtoJeux) {
        if ( dtoJeux == null ) {
            return null;
        }

        Jeux jeux = new Jeux();

        return jeux;
    }
}
