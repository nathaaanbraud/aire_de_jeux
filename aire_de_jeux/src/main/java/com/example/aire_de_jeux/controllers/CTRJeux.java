package com.example.aire_de_jeux.controllers;

import com.example.aire_de_jeux.dto.DTOJeux;
import com.example.aire_de_jeux.dto.DTOReservation;
import com.example.aire_de_jeux.errors.ResourceNotFoundException;
import com.example.aire_de_jeux.repositories.REPJeux;
import com.example.aire_de_jeux.services.SERJeux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Contrôleur pour gérer les opérations liées aux jeux.
 * Fournit des points d'accès API pour créer, mettre à jour, supprimer
 * et consulter des informations sur les jeux.
 */
@RestController
@RequestMapping("/api/jeux")
public class CTRJeux {

    @Autowired
    private REPJeux REPJeux;

    @Autowired
    private SERJeux SERJeux;

    /**
     * Met à jour les informations d'un jeu existant.
     *
     * @param dtoJeux l'objet DTO contenant les données mises à jour du jeu.
     * @return une réponse HTTP avec le jeu mis à jour (200 OK) ou une erreur si le jeu n'existe pas (404 Not Found).
     */
    @PutMapping("/{id}")
    public ResponseEntity<DTOJeux> setJeux(@RequestBody DTOJeux dtoJeux) {
        Optional<DTOJeux> updatedJeux = SERJeux.updateJeux(dtoJeux);

        return updatedJeux
                .map(ResponseEntity::ok) // Si présent, retourne 200 OK avec le DTO mis à jour
                .orElseThrow(() -> new ResourceNotFoundException("Aire de jeux introuvable")); // Sinon, retourne 404 Not Found
    }

    /**
     * Ajoute un nouveau jeu.
     *
     * @param dtoJeux l'objet DTO contenant les informations du nouveau jeu.
     * @return une réponse HTTP contenant le jeu créé (200 OK).
     */
    @PostMapping()
    public ResponseEntity<DTOJeux> addJeux(@RequestBody DTOJeux dtoJeux) {
        DTOJeux newdtoJeux = SERJeux.createJeux(dtoJeux);
        return ResponseEntity.ok(newdtoJeux);
    }

    /**
     * Supprime un jeu existant par son ID.
     *
     * @param id l'ID du jeu à supprimer.
     * @return une réponse HTTP avec 204 No Content si la suppression réussit,
     * ou 404 Not Found si le jeu n'existe pas.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJeux(@PathVariable Integer id) {
        boolean isDeleted = SERJeux.deleteJeux(id);

        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content si la suppression réussit
        } else {
            throw new ResourceNotFoundException("Aire de jeux introuvable"); // 404 Not Found si l'ID n'existe pas
        }
    }

    /**
     * Récupère un jeu par son ID.
     *
     * @param id l'ID du jeu à récupérer.
     * @return une réponse HTTP avec le jeu correspondant (200 OK) ou une erreur si le jeu n'existe pas (404 Not Found).
     */
    @GetMapping("/{id}")
    public ResponseEntity<DTOJeux> getJeuxById(@PathVariable Integer id) {
        Optional<DTOJeux> jeux = SERJeux.getJeuxById(id);
        return jeux
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Aire de jeux introuvable"));
    }

    /**
     * Récupère la liste de tous les jeux.
     *
     * @return une liste de tous les jeux disponibles.
     */
    @GetMapping
    public List<DTOJeux> getAllJeux() {
        return SERJeux.getAllReservations();
    }
}