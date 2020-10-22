package fr.bengi.natsystem.bataille.models;

public class Carte {

	private String nom;
	private String couleur;
	private int valeur;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public int getValeur() {
		return valeur;
	}
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	@Override
	public String toString() {
		return  nom + " de " + couleur ;
	}	
	
}
