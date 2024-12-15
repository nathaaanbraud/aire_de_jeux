package com.example.aire_de_jeux.services;

import com.example.aire_de_jeux.dto.DTOUtilisateur;
import com.example.aire_de_jeux.entities.Utilisateur;
import com.example.aire_de_jeux.mappers.MAPUtilisateur;
import com.example.aire_de_jeux.repositories.REPUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service pour gérer les opérations liées aux utilisateurs.
 */
@Service
public class SERUtilisateur {

    @Autowired
    private REPUtilisateur repUtilisateur;

    @Autowired
    private MAPUtilisateur mapUtilisateur;

    /**
     * Crée un nouvel utilisateur à partir d'un DTO.
     *
     * @param dtoUtilisateur Les données de l'utilisateur à créer encapsulées dans un DTO.
     * @return Le DTO de l'utilisateur créé.
     */
    public DTOUtilisateur createUtilisateur(DTOUtilisateur dtoUtilisateur) {
        Utilisateur utilisateur = mapUtilisateur.toEntity(dtoUtilisateur);
        Utilisateur savedUtilisateur = repUtilisateur.save(utilisateur);
        return mapUtilisateur.toDTO(savedUtilisateur);
    }

    /**
     * Récupère un utilisateur par son identifiant.
     *
     * @param id L'identifiant de l'utilisateur à récupérer.
     * @return Un Optional contenant le DTO de l'utilisateur, ou vide si l'utilisateur n'existe pas.
     */
    public Optional<DTOUtilisateur> getUtilisateurById(Integer id) {
        return repUtilisateur.findById(id).map(mapUtilisateur::toDTO);
    }

    /**
     * Récupère une liste d'utilisateurs correspondant à un nom donné.
     *
     * @param nom Le nom des utilisateurs à rechercher.
     * @return Une liste de DTO des utilisateurs correspondants.
     */
    public List<DTOUtilisateur> getUtilisateurByNom(String nom) {
        return repUtilisateur.findByNom(nom).stream()
                .map(mapUtilisateur::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Récupère la liste de tous les utilisateurs.
     *
     * @return Une liste de DTO contenant tous les utilisateurs.
     */
    public List<DTOUtilisateur> getAllUtilisateur() {
        return repUtilisateur.findAll().stream()
                .map(mapUtilisateur::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Met à jour un utilisateur existant.
     *
     * @param id            L'identifiant de l'utilisateur à mettre à jour.
     * @param dtoUtilisateur Les nouvelles données de l'utilisateur encapsulées dans un DTO.
     * @return Un Optional contenant le DTO de l'utilisateur mis à jour, ou vide si l'utilisateur n'existe pas.
     */
    public Optional<DTOUtilisateur> updateUtilisateur(Integer id, DTOUtilisateur dtoUtilisateur) {
        if (repUtilisateur.existsById(id)) {
            Utilisateur utilisateurToUpdate = mapUtilisateur.toEntity(dtoUtilisateur);
            utilisateurToUpdate.setId(id);
            Utilisateur updatedUtilisateur = repUtilisateur.save(utilisateurToUpdate);
            return Optional.of(mapUtilisateur.toDTO(updatedUtilisateur));
        }
        return Optional.empty();
    }

    /**
     * Supprime un utilisateur par son identifiant.
     *
     * @param id L'identifiant de l'utilisateur à supprimer.
     * @return true si l'utilisateur a été supprimé, false s'il n'existe pas.
     */
    public boolean deleteUtilisateur(Integer id) {
        if (repUtilisateur.existsById(id)) {
            repUtilisateur.deleteById(id);
            return true;
        }
        return false;
    }
}
