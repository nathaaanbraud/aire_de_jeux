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

    /**
     * Trouve un utilisateur par son adresse mail.
     *
     * @param mail l'adresse mail de l'utilisateur.
     * @return un Optional contenant l'utilisateur, ou vide si l'utilisateur n'existe pas.
     */
    Optional<Utilisateur> findByMail(String mail);

    /**
     * Vérifie si un utilisateur existe pour une adresse mail spécifique.
     *
     * @param mail l'adresse mail de l'utilisateur.
     * @return true si l'utilisateur existe, sinon false.
     */
    boolean existsByMail(String mail);
}
