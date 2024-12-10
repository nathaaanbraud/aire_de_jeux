package com.example.aire_de_jeux.repositories;
import com.example.aire_de_jeux.entities.Jeux;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface pour le dépôt des entités `Jeux`.
 * Permet d'effectuer des opérations CRUD sur les entités `Jeux` dans la base de données.
 */
public interface REPJeux extends JpaRepository<Jeux, Integer> {}