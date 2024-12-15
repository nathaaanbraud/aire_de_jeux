package com.example.aire_de_jeux.repositories;

import com.example.aire_de_jeux.entities.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

/**
 * Interface pour le dépôt des entités `Utilisateur`.
 * Permet d'effectuer des opérations CRUD sur les entités `Utilisateur` dans la base de données.
 */
public interface REPUtilisateur extends JpaRepository<Utilisateur, Integer> {

    /**
     * Trouve tous les utilisateurs ayant un nom spécifique.
     *
     * @param nom le nom de l'utilisateur.
     * @return une liste d'utilisateurs correspondant au nom fourni.
     */
    List<Utilisateur> findByNom(String nom);
    Optional<Utilisateur> findByMail(String mail);
}
