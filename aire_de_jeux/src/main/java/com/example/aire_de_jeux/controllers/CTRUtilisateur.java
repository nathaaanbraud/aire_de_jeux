package com.example.aire_de_jeux.controllers;

import com.example.aire_de_jeux.dto.DTOUtilisateur;
import com.example.aire_de_jeux.mappers.MAPUtilisateur;
import com.example.aire_de_jeux.entities.Utilisateur;
import com.example.aire_de_jeux.services.*;
import com.example.aire_de_jeux.services.SERUtilisateur;
import com.example.aire_de_jeux.errors.ResourceNotFoundException;
import com.example.aire_de_jeux.mappers.MAPUtilisateur;
import com.example.aire_de_jeux.entities.Utilisateur;
import com.example.aire_de_jeux.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Contrôleur pour gérer les opérations liées aux utilisateurs.
 * Fournit des points d'accès API pour créer, lire, mettre à jour et supprimer des utilisateurs.
 */
@RestController
@RequestMapping("/api/utilisateurs")
@RequiredArgsConstructor
public class CTRUtilisateur {

    /**
     * Service de gestion des utilisateurs.
     */
    final private SERUtilisateur SERUtil;

    /**
     * Récupère tous les utilisateurs.
     *
     * @return une liste de tous les utilisateurs.
     */
    @GetMapping
    public List<DTOUtilisateur> getAllUtilisateur() {
        return SERUtil.getAllUtilisateur();
    }

    /**
     * Récupère un utilisateur par son ID.
     *
     * @param id l'ID de l'utilisateur à récupérer.
     * @return une réponse HTTP contenant l'utilisateur (200 OK) ou une erreur (404 Not Found si non trouvé).
     */
    @GetMapping("/{id}")
    public ResponseEntity<DTOUtilisateur> getUtilisateurById(@PathVariable Integer id) {
        Optional<DTOUtilisateur> utilisateur = SERUtil.getUtilisateurById(id);
        return utilisateur
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Récupère les utilisateurs par leur nom.
     *
     * @param nom le nom des utilisateurs à rechercher.
     * @return une liste d'utilisateurs correspondant au nom donné.
     */
    @GetMapping("/nom/{nom}")
    public List<DTOUtilisateur> getUtilisateurByNom(@PathVariable String nom) {
        return SERUtil.getUtilisateurByNom(nom);
    }

    /**
     * Crée un nouvel utilisateur.
     *
     * @param dtoUtilisateur l'objet DTO contenant les informations de l'utilisateur à créer.
     * @return une réponse HTTP avec l'utilisateur créé (200 OK).
     */
    @PostMapping
    public ResponseEntity<DTOUtilisateur> createUtilisateur(@RequestBody DTOUtilisateur dtoUtilisateur) {
        DTOUtilisateur nouvelUtilisateur = SERUtil.createUtilisateur(dtoUtilisateur);
        return ResponseEntity.ok(nouvelUtilisateur);
    }

    /**
     * Met à jour un utilisateur existant par son ID.
     *
     * @param id             l'ID de l'utilisateur à mettre à jour.
     * @param dtoUtilisateur l'objet DTO contenant les nouvelles informations de l'utilisateur.
     * @return une réponse HTTP avec l'utilisateur mis à jour (200 OK) ou une erreur (404 Not Found si non trouvé).
     */
    @PutMapping("/{id}")
    public ResponseEntity<DTOUtilisateur> updateUtilisateur(@PathVariable Integer id, @RequestBody DTOUtilisateur dtoUtilisateur) {
        Optional<DTOUtilisateur> updatedUtil = SERUtil.updateUtilisateur(id, dtoUtilisateur);
        return updatedUtil
                .map(ResponseEntity::ok) // Si présent, retourne 200 OK avec le DTO mis à jour
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur introuvable") ); // Sinon, retourne 404 Not Found
    }

    /**
     * Supprime un utilisateur par son ID.
     *
     * @param id l'ID de l'utilisateur à supprimer.
     * @return une réponse HTTP 204 No Content si la suppression réussit,
     * ou 404 Not Found si l'utilisateur n'existe pas.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Integer id) {
        boolean isDeleted = SERUtil.deleteUtilisateur(id);

        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            throw new ResourceNotFoundException("Utilisateur introuvable"); // 404 Not Found si l'ID n'existe pas
        }
    }


    // Pour se login
    @PostMapping("/login")
    public ResponseEntity<DTOUtilisateur> loginUtilisateur(@RequestBody DTOLogin dtoLogin) {
        String email = dtoLogin.getMail();
        String password = dtoLogin.getPassword();

        Optional<DTOUtilisateur> utilisateur = SERUtil.loginUtilisateur(email, password);

        if (utilisateur.isPresent()) {
            return ResponseEntity.ok(utilisateur.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }


}
