package com.example.aire_de_jeux.mappers;

import com.example.aire_de_jeux.dto.DTOJeux;
import com.example.aire_de_jeux.entities.Jeux;
import org.mapstruct.Mapper;

@Mapper
public interface MAPJeux {
    DTOJeux toDTO(Jeux jeux);
    Jeux toEntity(DTOJeux dtoJeux);
}
