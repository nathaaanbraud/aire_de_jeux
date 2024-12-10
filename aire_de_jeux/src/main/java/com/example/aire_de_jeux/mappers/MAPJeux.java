package com.example.aire_de_jeux.mappers;

import com.example.aire_de_jeux.dto.DTOJeux;
import com.example.aire_de_jeux.entities.Jeux;
import org.mapstruct.Mapper;

/**
 * Interface de mappage pour l'entité `Jeux` et son DTO associé `DTOJeux`.
 * Utilise MapStruct pour faciliter la conversion entre les objets `Jeux` et `DTOJeux`.
 */
@Mapper
public interface MAPJeux {

    /**
     * Convertit une entité `Jeux` en un objet `DTOJeux`.
     *
     * @param jeux l'entité `Jeux` à convertir.
     * @return l'objet `DTOJeux` correspondant à l'entité `Jeux`.
     */
    DTOJeux toDTO(Jeux jeux);

    /**
     * Convertit un objet `DTOJeux` en une entité `Jeux`.
     *
     * @param dtoJeux le DTO `DTOJeux` à convertir.
     * @return l'entité `Jeux` correspondante à l'objet `DTOJeux`.
     */
    Jeux toEntity(DTOJeux dtoJeux);
}
