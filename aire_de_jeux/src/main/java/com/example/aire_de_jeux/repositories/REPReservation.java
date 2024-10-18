package com.example.aire_de_jeux.repositories;
import com.example.aire_de_jeux.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface REPReservation extends JpaRepository<Reservation, Long> {
}
