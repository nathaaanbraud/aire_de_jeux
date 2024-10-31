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

@Service
public class SERUtilisateur {

    @Autowired
    private REPUtilisateur repUtilisateur;

    @Autowired
    private MAPUtilisateur mapUtilisateur;

    // Création
    public DTOUtilisateur createUtilisateur(DTOUtilisateur dtoUtilisateur) {
        Utilisateur utilisateur = mapUtilisateur.toEntity(dtoUtilisateur);
        Utilisateur savedUtilisateur = repUtilisateur.save(utilisateur);
        return mapUtilisateur.toDTO(savedUtilisateur);
    }

    // Récupération unitaire
    public Optional<DTOUtilisateur> getUtilisateurById(Integer id) {
        return repUtilisateur.findById(id).map(mapUtilisateur::toDTO);
    }

    // Récupération par nom
    public List<DTOUtilisateur> getUtilisateurByNom(String nom) {
        return repUtilisateur.findByNom(nom).stream()
                .map(mapUtilisateur::toDTO)
                .collect(Collectors.toList());
    }

    // Récupération par liste
    public List<DTOUtilisateur> getAllUtilisateur() {
        return repUtilisateur.findAll().stream()
                .map(mapUtilisateur::toDTO)
                .collect(Collectors.toList());
    }

    // Mise à jour
    public Optional<DTOUtilisateur> updateUtilisateur(Integer id, DTOUtilisateur dtoUtilisateur) {
        if (repUtilisateur.existsById(id)) {
            Utilisateur utilisateurToUpdate = mapUtilisateur.toEntity(dtoUtilisateur);
            utilisateurToUpdate.setId(id);
            Utilisateur updatedUtilisateur = repUtilisateur.save(utilisateurToUpdate);
            return Optional.of(mapUtilisateur.toDTO(updatedUtilisateur));
        }
        return Optional.empty();
    }

    // Suppression
    public boolean deleteUtilisateur(Integer id) {
        if (repUtilisateur.existsById(id)) {
            repUtilisateur.deleteById(id);
            return true;
        }
        return false;
    }
}
