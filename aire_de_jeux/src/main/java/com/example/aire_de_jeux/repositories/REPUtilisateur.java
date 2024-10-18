package com.example.aire_de_jeux.repositories;
import com.example.aire_de_jeux.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface REPUtilisateur extends JpaRepository<Utilisateur, Long> {
}
