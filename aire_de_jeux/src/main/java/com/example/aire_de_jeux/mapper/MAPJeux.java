package com.example.aire_de_jeux.mapper;

import com.example.aire_de_jeux.dto.DTOJeux;
import com.example.aire_de_jeux.models.Jeux;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MAPJeux {
    DTOJeux toDTO(Jeux jeux);
    Jeux toEntity(DTOJeux dtoJeux);
}
