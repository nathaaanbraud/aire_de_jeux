package com.example.aire_de_jeux.controllers;

import com.example.aire_de_jeux.dto.DTOUtilisateur;
import com.example.aire_de_jeux.mappers.MAPUtilisateur;
import com.example.aire_de_jeux.entities.Utilisateur;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateurs")
public class CTRUtilisateur {
    /*
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
        //TODO
        return null;
    }

    @PutMapping("/{id}")
    public void updateUtilisateur(@PathVariable Long id, @RequestBody DTOUtilisateur dtoUtilisateur) {
        //TODo
    }

    @DeleteMapping("/{id}")
    public  void deleteUtilisateur(@PathVariable Long id) {
        //TODO
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
    */
}
