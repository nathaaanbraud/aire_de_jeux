package com.example.aire_de_jeux.repositories;
import com.example.aire_de_jeux.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface REPUtilisateur extends JpaRepository<Utilisateur, Integer> {
    List<Utilisateur> findByNom(String nom);
    Optional<Utilisateur> findByMail(String mail);
}
