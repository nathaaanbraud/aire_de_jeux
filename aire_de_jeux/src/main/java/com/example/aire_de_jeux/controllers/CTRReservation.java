package com.example.aire_de_jeux.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class CTRReservation {

    @PostMapping
    public void addReservation(@RequestBody String reservation) {
        // TODO: Implement this method
    }

    @DeleteMapping("/{reservation}")
    public void deleteReservation(@PathVariable String reservation) {
        // TODO: Implement this method
    }

    @GetMapping
    public List<String> getAllReservations() {
        // TODO: Implement this method
        return new ArrayList<>();
    }

    // TODO: Récupération par liste, unitaire, création, modification, suppression (valable pour tous les contrôleurs)
}