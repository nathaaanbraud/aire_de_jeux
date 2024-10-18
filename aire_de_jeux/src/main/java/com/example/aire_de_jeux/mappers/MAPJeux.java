package com.example.aire_de_jeux.mappers;

import com.example.aire_de_jeux.dto.DTOJeux;
import com.example.aire_de_jeux.entities.Jeux;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MAPJeux {
    DTOJeux toDTO(Jeux jeux);
    Jeux toEntity(DTOJeux dtoJeux);
}
