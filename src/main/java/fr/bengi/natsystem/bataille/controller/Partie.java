package fr.bengi.natsystem.bataille.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.bengi.natsystem.bataille.InitJeuCarte;
import fr.bengi.natsystem.bataille.InitJeuCarteImpl;
import fr.bengi.natsystem.bataille.models.Carte;
import fr.bengi.natsystem.bataille.models.Joueur;

public class Partie {

	private int nbJoueur;
	private List<Joueur> joueurs;
	private List<Carte> cartes;

	public Partie(int nbJoueur) {
		this.nbJoueur = nbJoueur;
		nomJoueur();
	}

	public int getNbJoueur() {
		return nbJoueur;
	}

	/**
	 * Création automatique des joueurs. Les noms seront "joueur1", "joueur2", etc..
	 */
	public void nomJoueur() {
		joueurs = new ArrayList<Joueur>();
		for (int i = 1; i <= nbJoueur; i++) {
			Joueur joueur = new Joueur();
			joueur.setNom("Joueur " + i);
			joueurs.add(joueur);
		}
	}

	/**
	 * Initialisation du jeu de carte (52 cartes ici) et on les mélange
	 * 
	 * @return cartes
	 */
	public List<Carte> melangeCarte() {
		InitJeuCarte jeuCarte = new InitJeuCarteImpl();
		cartes = jeuCarte.jeu52Cartes();
		Collections.shuffle(cartes);
		return cartes;
	}

	/**
	 * Distribution des cartes aux joueurs
	 */
	public void distribution() {
		melangeCarte();
		for (int i = 0; i < nbJoueur; i++) {
			List<Carte> mainJoueur = new ArrayList<Carte>();
			for (int j = i; j < cartes.size(); j += nbJoueur) {
				mainJoueur.add(cartes.get(j));
			}
			joueurs.get(i).setMainJoueur(mainJoueur);
		}
	}

	/**
	 * Tirage de la première carte du paquet des joueurs
	 */
	public void tirageCarte() {
		for (int i = 0; i < nbJoueur; i++) {
			Carte carteJoueur = new Carte();
			carteJoueur = joueurs.get(i).getMainJoueur().get(0);
			joueurs.get(i).setCarteTapis(carteJoueur);
		}
	}

	/**
	 * Comparaison de 2 cartes
	 * @param carte
	 * @param carte2
	 * @return
	 */
	public Carte comparaisonDeuxCartes(Carte carte, Carte carte2) {
		Carte cartePlusForte;
		if (carte.getValeur() > carte2.getValeur()) {
			cartePlusForte = carte;
		} else {
			cartePlusForte = carte2;
		}
		return cartePlusForte;
	}

	/**
	 * Comparaison des cartes de tous les joueurs.
	 * @return
	 */
	public List<Joueur> comparaisonCarte() {
		initCarteTapis();
		tirageCarte();

		/**
		 * Afin de gérer au plus juste l'égalité, un mélange de l'ordre des joueurs
		 * est fait.  Le première qui aura la plus forte carte suivant cet ordre
		 * sera vainqueur 
		 */
		Collections.shuffle(joueurs);

		Joueur joueurPlusFort = joueurs.get(0);

		for (Joueur joueur : joueurs) {
			if (joueur.getNom() != joueurPlusFort.getNom()) {
				Carte retourCarte = comparaisonDeuxCartes(joueur.getCarteTapis(), joueurPlusFort.getCarteTapis());
				if (retourCarte.equals(joueur.getCarteTapis())) {
					joueurPlusFort = joueur;
				}
			}
		}
		attributionDesCartes(joueurPlusFort);
		return joueurs;
	}

	/**
	 * Ajouter les cartes au vainqueur du tour et les retirer aux perdants.
	 * @param joueurPlusFort
	 */
	public void attributionDesCartes(Joueur joueurPlusFort) {
		for (Joueur joueur : joueurs) {
			if (joueur.getNom().equals(joueurPlusFort.getNom())) {
				joueur.getMainJoueur().remove(0);
				for (Joueur joueurz : joueurs) {
					joueur.getMainJoueur().add(joueurz.getCarteTapis());
				}
			} else {
				joueur.getMainJoueur().remove(0);
			}
		}
	}

	/**
	 * Initialisation du tapis de chaques joueurs
	 */
	public void initCarteTapis() {
		for (Joueur joueur : joueurs) {
			joueur.setCarteTapis(null);
		}
	}
}
