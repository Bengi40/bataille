package fr.bengi.natsystem.bataille.models;

public enum CouleurCarte {
	PIQUE("pique"), COEUR("coeur"), CARREAU(("carreau")), TREFLE("trèfle");
	
	private final String couleur;

	private CouleurCarte(String couleur) {
		this.couleur = couleur;
	}

	public String getCouleur() {
		return couleur;
	}
}
