package fr.bengi.natsystem.bataille.models;

import java.util.List;

public class Joueur {
	private String nom;
	private List<Carte> mainJoueur;
	private Carte carteTapis;
	
	public Joueur() {
	}
	
	public Joueur(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Carte> getMainJoueur() {
		return mainJoueur;
	}
	public void setMainJoueur(List<Carte> mainJoueur) {
		this.mainJoueur = mainJoueur;
	}
	
	public Carte getCarteTapis() {
		return carteTapis;
	}

	public void setCarteTapis(Carte carteTapis) {
		this.carteTapis = carteTapis;
	}

	@Override
	public String toString() {
		return  nom;
	}
}
