package fr.bengi.natsystem.bataille;

import java.util.ArrayList;
import java.util.List;

import fr.bengi.natsystem.bataille.models.Carte;
import fr.bengi.natsystem.bataille.models.CouleurCarte;
import fr.bengi.natsystem.bataille.models.NomCarte;

public class InitJeuCarteImpl implements InitJeuCarte {

	@Override
	public List<Carte> jeu52Cartes() {
		List<Carte> cartes= new ArrayList<Carte>();
                
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
