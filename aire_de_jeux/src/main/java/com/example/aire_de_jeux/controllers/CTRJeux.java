package com.example.aire_de_jeux.controllers;

import com.example.aire_de_jeux.dto.DTOJeux;
import com.example.aire_de_jeux.repositories.REPJeux;
import com.example.aire_de_jeux.services.SERJeux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/jeux")
public class CTRJeux {

    @Autowired
    private REPJeux REPJeux;

    @Autowired // Ajoutez cette annotation
    private SERJeux SERJeux; // Assurez-vous que SERJeux est également un service Spring

    // Modifier un jeu
    @PutMapping("/{id}")
    public ResponseEntity<DTOJeux> setJeux(@PathVariable Integer id, @RequestBody DTOJeux dtoJeux) {
        Optional<DTOJeux> updatedJeux = SERJeux.updateJeux(id, dtoJeux);

        return updatedJeux
                .map(ResponseEntity::ok) // Si présent, retourne 200 OK avec le DTO mis à jour
                .orElseGet(() -> ResponseEntity.notFound().build()); // Sinon, retourne 404 Not Found
    }

    // Ajouter un jeu
    @PostMapping("/jeux")
    public ResponseEntity<DTOJeux> addUtilisateur(@RequestBody DTOJeux dtoJeux) {
        DTOJeux newdtoJeux = SERJeux.createJeux(dtoJeux);
        return ResponseEntity.ok(newdtoJeux);
    }

    @DeleteMapping("/deleteJeux/{id}")
    public ResponseEntity<Void> deleteJeux(@PathVariable Integer id) {
        boolean isDeleted = SERJeux.deleteJeux(id);

        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content si la suppression réussit
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found si l'ID n'existe pas
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOJeux> getJeuxById(@PathVariable Integer id) {
        Optional<DTOJeux> jeux = SERJeux.getJeuxById(id);
        return jeux
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }
}
