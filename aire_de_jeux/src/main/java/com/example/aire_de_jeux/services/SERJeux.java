package com.example.aire_de_jeux.services;

import com.example.aire_de_jeux.dto.DTOJeux;
import com.example.aire_de_jeux.entities.Jeux;
import com.example.aire_de_jeux.mappers.MAPJeux;
import com.example.aire_de_jeux.repositories.REPJeux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SERJeux {

    @Autowired
    private REPJeux repJeux;

    @Autowired
    private MAPJeux mapJeux;

    // Création
    public DTOJeux createJeux(DTOJeux dtoJeux) {
        Jeux jeux = mapJeux.toEntity(dtoJeux);
        Jeux savedJeux = repJeux.save(jeux);
        return mapJeux.toDTO(savedJeux);
    }

    // Récupération unitaire
    public Optional<DTOJeux> getJeuxById(Integer id) {
        return repJeux.findById(id).map(mapJeux::toDTO);
    }

    // Récupération par liste
    public List<DTOJeux> getAllJeux() {
        return repJeux.findAll().stream()
                .map(mapJeux::toDTO)
                .collect(Collectors.toList());
    }

    // Mise à jour
    public Optional<DTOJeux> updateJeux(Integer id, DTOJeux dtoJeux) {
        if (repJeux.existsById(id)) {
            Jeux jeuxToUpdate = mapJeux.toEntity(dtoJeux);
            jeuxToUpdate.setId(id);
            Jeux updatedJeux = repJeux.save(jeuxToUpdate);
            return Optional.of(mapJeux.toDTO(updatedJeux));
        }
        return Optional.empty();
    }

    // Suppression
    public boolean deleteJeux(Integer id) {
        if (repJeux.existsById(id)) {
            repJeux.deleteById(id);
            return true;
        }
        return false;
    }
}
