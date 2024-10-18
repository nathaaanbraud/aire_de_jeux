package com.example.aire_de_jeux.repositories;
import com.example.aire_de_jeux.entities.Jeux;
import com.example.aire_de_jeux.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface REPJeux extends JpaRepository<Jeux, Long> {
    Optional<Jeux> findByID(Integer id);
}

