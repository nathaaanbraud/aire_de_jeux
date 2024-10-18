package com.example.aire_de_jeux.repositories;
import com.example.aire_de_jeux.entities.Reservation;
import com.example.aire_de_jeux.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface REPReservation extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findByID(Integer id);
}
