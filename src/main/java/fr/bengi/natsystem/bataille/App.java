package fr.bengi.natsystem.bataille;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import fr.bengi.natsystem.bataille.controller.Partie;
import fr.bengi.natsystem.bataille.controller.PartieImpl;
import fr.bengi.natsystem.bataille.models.Carte;
import fr.bengi.natsystem.bataille.models.Joueur;

public class App 
{
	public static void main( String[] args )
    {

		InitJeuCarte init = new InitJeuCarteImpl();
		Set<Carte> jeuCarte = new LinkedHashSet<Carte>();
		jeuCarte = init.jeu52Cartes();
		
		System.out.println("Affichage du jeu de cartes");
		System.out.println("+---------------------+----------------------+----------------------+---------------------+");
		int nbCarteParCouleur = jeuCarte.size() / 4;
		
		List<Carte> listCarte = new ArrayList<Carte>(jeuCarte);
		
		for (int i=0;i<nbCarteParCouleur ;i++) {
			System.out.printf("|  %17s  |  %17s   |  %17s   |  %17s  |\n",
					listCarte.get(i),
					listCarte.get(i+nbCarteParCouleur),
					listCarte.get(i+nbCarteParCouleur*2),
					listCarte.get(i+nbCarteParCouleur*3)
					);
		}
		
		System.out.println("+---------------------+----------------------+----------------------+---------------------+\n");
		
    	System.out.println("+--------------------------------+");
    	System.out.println("| DEBUT DE LA PARTIE A 4 JOUEURS |");
    	System.out.println("+--------------------------------+");
    	
        Partie partie = new PartieImpl(4);
        List<Joueur> joueurs = new ArrayList<Joueur>();
        joueurs = partie.getJoueurs();
        
        List<Carte> jeuDeCarte = new ArrayList<Carte>(partie.initTasCarte());
     
        partie.melangeCarte(jeuDeCarte);
        
        partie.distribution(jeuDeCarte);
        partie.initCarteTapis(joueurs);
        partie.tirageCarte();
        
        Joueur joueurPlusFort = partie.comparaisonCarte();
        partie.attributionDesCartes(joueurPlusFort);
        for(int i = 0; i < 1; i++) {

        	
        	System.out.println("Main des joueurs : ");
        	for (Joueur joueur : joueurs) {
				System.out.println("le joueur " + joueur.getNom() + " sort la carte " + joueur.getCarteTapis());
			}
        	System.out.println("+--------------------------------+");
        	
            for (Joueur joueur : joueurs) {
    			System.out.println("Main de "+ joueur.getNom() + " : " + joueur.getMainJoueur().size());
    		}
            System.out.println("-----------------------------");
        }

    }
}
