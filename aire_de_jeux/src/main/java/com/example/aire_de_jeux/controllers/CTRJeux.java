package com.example.aire_de_jeux.controllers;
import com.example.aire_de_jeux.dto.DTOJeux;
import com.example.aire_de_jeux.repositories.*;
import com.example.aire_de_jeux.entities.Jeux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import lombok.*;

@RestController
@RequestMapping("/api/jeux")
public class CTRJeux {
    /*
    @Autowired
    private REPJeux REPJeux;
    // Modifier un jeu
    @PutMapping("/{id}")
    public ResponseEntity<Jeux> setJeux(@PathVariable Integer id, @RequestBody DTOJeux jeuxDTO) {
        // Récupérer le jeu existant
        Optional<Jeux> jeuxOptional = REPJeux.findByID(id);
        if (jeuxOptional.isPresent()) {
            Jeux jeu = jeuxOptional.get();
            jeu.setNom(jeuxDTO.getNom());
            jeu.setQuantite(jeuxDTO.getQuantite());
            jeu.setDescription(jeuxDTO.getDescription());
            jeu.setPointGeo(jeuxDTO.getPointGeo());

            // Sauvegarder les modifications
            Jeux JeuMAJ = REPJeux.save(jeu);

            return ResponseEntity.ok(JeuMAJ);
        } else {
            return ResponseEntity.notFound().build();  // Si le jeu n'existe pas
        }
    }

    // Ajouter un jeu
    @PostMapping
    public ResponseEntity<Jeux> addUtilisateur(@RequestBody Jeux jeu) {
        Jeux newJeu = REPJeux.save(jeu);
        return ResponseEntity.ok(newJeu);
    }

    @DeleteMapping("/deleteJeux/{id}")
    public ResponseEntity<String> deleteJeux(@PathVariable Integer id) {
        Jeux jeux = REPJeux.findById((long) id).orElse(null);

        if (jeux != null) {
            REPJeux.deleteById((long) id);
            return new ResponseEntity<>("Jeu avec l'ID " + id + " a été supprimé avec succès.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Jeu avec l'ID " + id + " n'a pas été trouvé.", HttpStatus.NOT_FOUND);
        }
    }
    */
}

