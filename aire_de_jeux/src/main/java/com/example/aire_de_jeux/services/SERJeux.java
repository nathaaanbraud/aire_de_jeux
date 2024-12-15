package com.example.aire_de_jeux.services;

import com.example.aire_de_jeux.dto.DTOJeux;
import com.example.aire_de_jeux.dto.DTOReservation;
import com.example.aire_de_jeux.entities.Jeux;
import com.example.aire_de_jeux.mappers.MAPJeux;
import com.example.aire_de_jeux.repositories.REPJeux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service pour gérer les opérations liées aux jeux.
 */
@Service
public class SERJeux {

    @Autowired
    private REPJeux repJeux;

    @Autowired
    private MAPJeux mapJeux;

    /**
     * Crée un nouveau jeu à partir d'un DTO.
     *
     * @param dtoJeux Les données du jeu à créer encapsulées dans un DTO.
     * @return Le DTO du jeu créé.
     */
    public DTOJeux createJeux(DTOJeux dtoJeux) {
        Jeux jeux = mapJeux.toEntity(dtoJeux);
        Jeux savedJeux = repJeux.save(jeux);
        return mapJeux.toDTO(savedJeux);
    }

    /**
     * Récupère un jeu par son identifiant.
     *
     * @param id L'identifiant du jeu à récupérer.
     * @return Un Optional contenant le DTO du jeu, ou vide si le jeu n'existe pas.
     */
    public Optional<DTOJeux> getJeuxById(Integer id) {
        return repJeux.findById(id).map(mapJeux::toDTO);
    }

    /**
     * Récupère la liste de tous les jeux.
     *
     * @return Une liste de DTO contenant tous les jeux.
     */
    public List<DTOJeux> getAllJeux() {
        return repJeux.findAll().stream()
                .map(mapJeux::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Met à jour un jeu existant.
     *
     * @param dtoJeux Les nouvelles données du jeu encapsulées dans un DTO.
     * @return Un Optional contenant le DTO du jeu mis à jour, ou vide si le jeu n'existe pas.
     */
    public Optional<DTOJeux> updateJeux(DTOJeux dtoJeux) {
        if (repJeux.existsById(dtoJeux.getId())) {
            Jeux jeuxToUpdate = mapJeux.toEntity(dtoJeux);
            Jeux updatedJeux = repJeux.save(jeuxToUpdate);
            return Optional.of(mapJeux.toDTO(updatedJeux));
        }
        return Optional.empty();
    }

    /**
     * Supprime un jeu par son identifiant.
     *
     * @param id L'identifiant du jeu à supprimer.
     * @return true si le jeu a été supprimé, false s'il n'existe pas.
     */
    public boolean deleteJeux(Integer id) {
        if (repJeux.existsById(id)) {
            repJeux.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Récupère la liste de toutes les réservations (même méthode que pour les jeux).
     *
     * @return Une liste de DTO contenant toutes les réservations.
     */
    public List<DTOJeux> getAllReservations() {
        return repJeux.findAll().stream()
                .map(mapJeux::toDTO)
                .collect(Collectors.toList());
    }
}
