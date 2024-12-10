package com.example.aire_de_jeux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principale de l'application Spring Boot.
 * Lance l'application en démarrant le contexte Spring et en initialisant l'application.
 */
@SpringBootApplication
public class DemoApplication {

	/**
	 * Méthode principale qui démarre l'application Spring Boot.
	 *
	 * @param args les arguments de la ligne de commande.
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}