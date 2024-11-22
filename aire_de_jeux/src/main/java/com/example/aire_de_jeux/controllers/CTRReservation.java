package com.example.aire_de_jeux.controllers;

import com.example.aire_de_jeux.dto.DTOReservation;
import com.example.aire_de_jeux.entities.ReservationId;
import com.example.aire_de_jeux.services.SERReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.example.aire_de_jeux.services.SERReservation;

@RestController
@RequestMapping("/api/reservations")
public class CTRReservation {

    @Autowired
    private SERReservation serReservation;

    //créer une nouvelle reservation
    @PostMapping
    public ResponseEntity<DTOReservation> createReservation(@RequestBody DTOReservation dtoReservation) {
        DTOReservation createdReservation = serReservation.createReservation(dtoReservation);
        return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);    // On peut utiliser 200 Ok, mais 201 Created est plus approprié
    }

    //recuperer toutes les reservations
    @GetMapping
    public List<DTOReservation> getAllReservations() {
        return serReservation.getAllReservations();
    }

    //recuperer une reservation par son id
    @GetMapping("/{id}")
    public ResponseEntity<DTOReservation> getReservationById(@PathVariable ReservationId id) {
        Optional<DTOReservation> reservation = serReservation.getReservationById(id);       //Optional car la réservation peut ne pas exister
        return reservation
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    //recuperer toutes les reservations d'un utilisateur
    @GetMapping("/utilisateur/{utilisateurId}")
    public List<DTOReservation> getReservationByUtilisateur(@PathVariable Integer utilisateurId) {
        return serReservation.getReservationByUtilisateur(utilisateurId);
    }

    //recuperer toutes les reservations d'un jeux
    @GetMapping("/jeux/{jeuxId}")
    public List<DTOReservation> getReservationByJeux(@PathVariable Integer jeuxId) {
        return serReservation.getReservationByJeux(jeuxId);
    }

    //mettre à jour une reservation
    @PutMapping("/{reservation}")
    public ResponseEntity<DTOReservation> updateReservation(@PathVariable int reservation, @RequestBody DTOReservation dtoReservation) {
        Optional<DTOReservation> updatedReservation = serReservation.updateReservation(reservation, dtoReservation);
        return updatedReservation
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //supprimer une reservation
    @DeleteMapping("/{utilisateurId}/{jeuxId}")
    public ResponseEntity<Void> deleteReservation(@PathVariable int utilisateurId, @PathVariable int jeuxId) {
        boolean isDeleted = serReservation.deleteReservation(utilisateurId, jeuxId);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Enlever ou rajouter des reservations (le nombre (la quantité))
    @PutMapping("/rajout/{nbReservations}")
    public ResponseEntity<DTOReservation> updateNbReservation(@PathVariable int nbReservations, @RequestBody DTOReservation dtoReservation) {
        Optional<DTOReservation> updatedReservation = serReservation.updateNbReservation(nbReservations, dtoReservation);
        return updatedReservation
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}