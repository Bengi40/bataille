package fr.bengi.natsystem.bataille.controller;

import java.util.List;

import fr.bengi.natsystem.bataille.models.Carte;
import fr.bengi.natsystem.bataille.models.Joueur;

public interface Partie {
	
	public int getNbJoueur();
	public void setNbJoueur(int nbJoueur);
	public List<Joueur> getJoueurs();
	public void setJoueurs(List<Joueur> joueurs);
	public List<Carte> getCartes();
	
	/**
	 * Création automatique des joueurs. Les noms seront "joueur1", "joueur2", etc..
	 */
	public void nomJoueur();
	
	/**
	 * Initialisation du jeu de carte (52 cartes ici)
	 * @return
	 */
	public List<Carte> initTasCarte();
	
	/**
	 * Mélanger les cartes
	 */
	public List<Carte> melangeCarte(List<Carte> cartes);
	
	/**
	 * Distribution des cartes aux joueurs
	 */
	public void distribution(List<Carte> cartes);
	
	/**
	 * Tirage de la première carte du paquet des joueurs
	 */
	public void tirageCarte();
	
	/**
	 * Comparaison de 2 cartes
	 * @param carte
	 * @param carte2
	 * @return
	 */
	public Carte comparaisonDeuxCartes(Carte carte, Carte carte2);
	
	/**
	 * Comparaison des cartes de tous les joueurs.
	 * @return du joueur le plus fort
	 */
	public Joueur comparaisonCarte();
	
	/**
	 * Ajouter les cartes au vainqueur du tour et les retirer aux perdants.
	 * @param joueurPlusFort
	 */
	public void attributionDesCartes(Joueur joueurPlusFort);
	
	/**
	 * Initialisation du tapis de chaques joueurs
	 */
	public void initCarteTapis(List<Joueur> joueurs) ;
}
