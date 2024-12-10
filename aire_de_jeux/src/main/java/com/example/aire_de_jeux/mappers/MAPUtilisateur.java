package com.example.aire_de_jeux.mappers;

import com.example.aire_de_jeux.dto.DTOUtilisateur;
import com.example.aire_de_jeux.entities.Utilisateur;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
/**
 * Interface de mappage pour l'entité `Utilisateur` et son DTO associé `DTOUtilisateur`.
 * Utilise MapStruct pour convertir les entités `Utilisateur` en `DTOUtilisateur` et inversement.
 *
 * Cette interface gère également des opérations après le mappage, comme la suppression du mot de passe dans le DTO.
 */
@Mapper
public interface MAPUtilisateur {

    /**
     * Convertit une entité `Utilisateur` en un objet `DTOUtilisateur`.
     *
     * @param utilisateur l'entité `Utilisateur` à convertir.
     * @return l'objet `DTOUtilisateur` correspondant à l'entité `Utilisateur`.
     */
    DTOUtilisateur toDTO(Utilisateur utilisateur);

    /**
     * Convertit un objet `DTOUtilisateur` en une entité `Utilisateur`.
     *
     * @param dtoUtilisateur l'objet `DTOUtilisateur` à convertir.
     * @return l'entité `Utilisateur` correspondant à l'objet `DTOUtilisateur`.
     */
    Utilisateur toEntity(DTOUtilisateur dtoUtilisateur);

    /**
     * Effectue une opération après le mappage d'un objet `Utilisateur` en `DTOUtilisateur`.
     * Cette méthode est appelée après le mappage pour vider le mot de passe dans le DTO, afin de ne pas exposer cette information.
     *
     * @param dtoUtilisateur l'objet `DTOUtilisateur` après le mappage.
     */
    @AfterMapping
    default void afterToDTO(@MappingTarget DTOUtilisateur dtoUtilisateur) {
        dtoUtilisateur.setPassword(""); // Supprime le mot de passe du DTO pour ne pas l'exposer.
    }
}