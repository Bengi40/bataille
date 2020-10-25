package fr.bengi.natsystem.bataille;

import java.util.LinkedHashSet;
import java.util.Set;

import fr.bengi.natsystem.bataille.models.Carte;
import fr.bengi.natsystem.bataille.models.CouleurCarte;
import fr.bengi.natsystem.bataille.models.NomCarte;

public class InitJeuCarteImpl implements InitJeuCarte {

	/**
	 * Constitution d'un jeu de 52 cartes
	 * Le LinkedHashSet assure l'unicité des cartes et les laisse dans l'ordre de création
	 */
	@Override
	public Set<Carte> jeu52Cartes() {
		Set<Carte> cartes = new LinkedHashSet<Carte>();
		for (CouleurCarte couleur : CouleurCarte.values()) {
        	for (NomCarte nomCartes : NomCarte.values()) {
        		Carte carte = new Carte();
        		carte.setNom(nomCartes.getNom());
        		carte.setValeur(nomCartes.getValeur());
        		carte.setCouleur(couleur.getCouleur());	
        		
        		cartes.add(carte);
        	}
        }
        return cartes;
	}
}
