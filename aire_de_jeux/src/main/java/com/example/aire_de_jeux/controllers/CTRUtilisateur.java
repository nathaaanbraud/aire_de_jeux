package com.example.aire_de_jeux.controllers;

import com.example.aire_de_jeux.dto.DTOJeux;
import com.example.aire_de_jeux.dto.DTOUtilisateur;
import com.example.aire_de_jeux.mappers.MAPUtilisateur;
import com.example.aire_de_jeux.entities.Utilisateur;
import com.example.aire_de_jeux.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateurs")
@RequiredArgsConstructor
public class CTRUtilisateur {

    final private SERUtilisateur SERUtil;

    //recuperer tous les utilisateurs
    @GetMapping
    public List<DTOUtilisateur> getAllUtilisateur() {
        List<DTOUtilisateur> listeUtilisateurs = SERUtil.getAllUtilisateur();
        return listeUtilisateurs;
    }

    //recuperer un utilisateur par son id
    @GetMapping("/{id}")
    public ResponseEntity<DTOUtilisateur> getUtilisateurById(@PathVariable Integer id) {
        Optional<DTOUtilisateur> utilisateur = SERUtil.getUtilisateurById(id);
        return utilisateur
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    //recuperer l'utilsateur pas son nom
    @GetMapping("/nom/{nom}")
    public List<DTOUtilisateur> getUtilisateurByNom(@PathVariable String nom) {
        List<DTOUtilisateur> listeUtilisateurs = SERUtil.getUtilisateurByNom(nom);
        return listeUtilisateurs;
    }

    @PostMapping
    public ResponseEntity<DTOUtilisateur> createUtilisateur(@RequestBody DTOUtilisateur dtoUtilisateur) {
        System.out.println("je suis dans le controller");
        DTOUtilisateur nouvelUtilisateur = SERUtil.createUtilisateur(dtoUtilisateur);
        return ResponseEntity.ok(nouvelUtilisateur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOUtilisateur> updateUtilisateur(@PathVariable Integer id, @RequestBody DTOUtilisateur dtoUtilisateur) {
        Optional<DTOUtilisateur> updatedUtil = SERUtil.updateUtilisateur(id, dtoUtilisateur);
        return updatedUtil
                .map(ResponseEntity::ok) // Si présent, retourne 200 OK avec le DTO mis à jour
                .orElseGet(() -> ResponseEntity.notFound().build()); // Sinon, retourne 404 Not Found
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Integer id) {
        boolean isDeleted = SERUtil.deleteUtilisateur(id);

        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content si la suppression réussit
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found si l'ID n'existe pas
        }
    }

}
