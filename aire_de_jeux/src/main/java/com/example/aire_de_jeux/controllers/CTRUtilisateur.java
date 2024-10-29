package com.example.aire_de_jeux.controllers;

import com.example.aire_de_jeux.dto.DTOJeux;
import com.example.aire_de_jeux.dto.DTOUtilisateur;
import com.example.aire_de_jeux.mappers.MAPUtilisateur;
import com.example.aire_de_jeux.entities.Utilisateur;
import com.example.aire_de_jeux.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateurs")
public class CTRUtilisateur {
    private SERUtilisateur SERUtil;
    @GetMapping  // Correction de l'annotation
    public ResponseEntity<List<DTOUtilisateur>> getAllUtilisateurs() {
        //TODO
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOUtilisateur> getUtilisateurById(@PathVariable Long id) {
        //TODO
        return null;
    }

    @PostMapping
    public ResponseEntity<DTOUtilisateur> createUtilisateur(@RequestBody DTOUtilisateur dtoUtilisateur) {
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

    @DeleteMapping("/deleteUtilisateur/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Integer id) {
        boolean isDeleted = SERUtil.deleteUtilisateur(id);

        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content si la suppression réussit
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found si l'ID n'existe pas
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<DTOUtilisateur>> searchUtilisateur(@RequestParam String nom) {
        //TODO
        return null;
    }

    @GetMapping("/search")
    public ResponseEntity<List<DTOUtilisateur>> searchUtilisateur(@RequestParam String nom, @RequestParam String prenom) {
        //TODO
        return null;
    }
}
