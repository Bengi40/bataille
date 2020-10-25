package fr.bengi.natsystem.bataille.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.bengi.natsystem.bataille.InitJeuCarte;
import fr.bengi.natsystem.bataille.InitJeuCarteImpl;
import fr.bengi.natsystem.bataille.models.Carte;
import fr.bengi.natsystem.bataille.models.Joueur;

public class PartieImpl implements Partie {

	private int nbJoueur;
	private List<Joueur> joueurs;
	private List<Carte> cartes;

	public PartieImpl() {
	}
	
	public PartieImpl(int nbJoueur) {
		this.nbJoueur = nbJoueur;
		nomJoueur();
	}

	public int getNbJoueur() {
		return nbJoueur;
	}

	public void setNbJoueur(int nbJoueur) {
		this.nbJoueur = nbJoueur;
	}

	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public List<Carte> getCartes() {
		return cartes;
	}

	public void nomJoueur() {
		joueurs = new ArrayList<Joueur>();
		for (int i = 1; i <= nbJoueur; i++) {
			Joueur joueur = new Joueur();
			joueur.setNom("Joueur " + i);
			joueurs.add(joueur);
		}
	}

	public List<Carte> initTasCarte() {
		InitJeuCarte jeuCarte = new InitJeuCarteImpl();
		cartes = new ArrayList<Carte>(jeuCarte.jeu52Cartes());
		return cartes;
	}

	public List<Carte> melangeCarte(List<Carte> cartes) {
		Collections.shuffle(cartes);
		return cartes;
	}

	public void distribution(List<Carte> cartes) {
		
		for (int i = 0; i < nbJoueur; i++) {
			List<Carte> mainJoueur = new ArrayList<Carte>();
			for (int j = i; j < cartes.size(); j += nbJoueur) {
				mainJoueur.add(cartes.get(j));
			}
			joueurs.get(i).setMainJoueur(mainJoueur);
		}
	}

	public void tirageCarte() {
		for (int i = 0; i < nbJoueur; i++) {
			Carte carteJoueur = new Carte();
			carteJoueur = joueurs.get(i).getMainJoueur().get(0);
			joueurs.get(i).setCarteTapis(carteJoueur);
		}
	}
	
	public Carte comparaisonDeuxCartes(Carte carte, Carte carte2) {
		Carte cartePlusForte;
		if (carte.getValeur() > carte2.getValeur()) {
			cartePlusForte = carte;
		} else {
			cartePlusForte = carte2;
		}
		return cartePlusForte;
	}

	public Joueur comparaisonCarte() {

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
		return joueurPlusFort;
	}
	
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
	
	public void initCarteTapis(List<Joueur> joueurs) {
		for (Joueur joueur : joueurs) {
			joueur.setCarteTapis(null);
		}
	}
}
