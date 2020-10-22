package fr.bengi.natsystem.bataille.models;

public enum NomCarte {
	DEUX(2, "2"),TROIS(3, "3"),QUATRE(4, "4"),CINQ(5, "5"),SIX(6, "6"),SEPT(7,"7"),HUIT(8,"8"),NEUF(9,"9"),DIX(10,"10"),
	VALET(11, "Valet"),REINE(12, "Reine"),ROI(13,"Roi"),AS(14,"As");
	
	private final int valeur;
	private final String nom;
	
	private NomCarte(int valeur,String nom) {
		this.valeur = valeur;
		this.nom = nom;
	}

	public int getValeur() {
		return valeur;
	}

	public String getNom() {
		return nom;
	}
}
