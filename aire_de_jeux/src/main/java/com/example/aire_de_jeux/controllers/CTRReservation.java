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
    @GetMapping("/utilisateur/{id}")
    public List<DTOReservation> getReservationByUtilisateur(@PathVariable Integer id) {
        return serReservation.getReservationByUtilisateur(id);
    }


    //recuperer toutes les reservations d'un jeux
    @GetMapping("/jeux/{id}")
    public List<DTOReservation> getReservationByJeux(@PathVariable Integer id) {
        return serReservation.getReservationByJeux(id);
    }

    //mettre à jour une reservation
    @PutMapping("/{id}")
    public ResponseEntity<DTOReservation> updateReservation(@PathVariable ReservationId id, @RequestBody DTOReservation dtoReservation) {
        Optional<DTOReservation> updatedReservation = serReservation.updateReservation(id, dtoReservation);
        return updatedReservation
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //supprimer une reservation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable ReservationId id) {
        boolean isDeleted = serReservation.deleteReservation(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    /*


    @DeleteMapping("/{id}")
    public void deleteReservationByIdUtilisateur(@PathVariable String id) {
        // TODO: Implement this method
    }

    */
}