package fr.bengi.natsystem.bataille;

import java.util.ArrayList;
import java.util.List;

import fr.bengi.natsystem.bataille.controller.Partie;
import fr.bengi.natsystem.bataille.models.Carte;
import fr.bengi.natsystem.bataille.models.Joueur;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
    {
    	InitJeuCarte init = new InitJeuCarteImpl();
    	List<Carte> jeuCarte = new ArrayList<Carte>();
		jeuCarte = init.jeu52Cartes();
    	
		System.out.println("Affichage du jeu de cartes");
		System.out.println("+---------------------+----------------------+----------------------+---------------------+");
		int nbCarteParCouleur = jeuCarte.size() / 4;
		
		for (int i=0;i<nbCarteParCouleur ;i++) {
			System.out.printf("|  %17s  |  %17s   |  %17s   |  %17s  |\n",
					jeuCarte.get(i).getNom() + " de " + jeuCarte.get(i).getCouleur(),
					jeuCarte.get(i+nbCarteParCouleur).getNom() + " de " + jeuCarte.get(i+nbCarteParCouleur).getCouleur(),
					jeuCarte.get(i+nbCarteParCouleur*2).getNom() + " de " + jeuCarte.get(i+nbCarteParCouleur*2).getCouleur(),
					jeuCarte.get(i+nbCarteParCouleur*3).getNom() + " de " + jeuCarte.get(i+nbCarteParCouleur*3).getCouleur()
					);
		}
		
		System.out.println("+---------------------+----------------------+----------------------+---------------------+\n");
    	
    	System.out.println("+--------------------------------+");
    	System.out.println("| DEBUT DE LA PARTIE A 4 JOUEURS |");
    	System.out.println("+--------------------------------+");
    	
        Partie partie = new Partie(4);
        partie.distribution();
        
        for(int i = 0; i < 1; i++) {
        	
        	List<Joueur> joueurs = partie.comparaisonCarte();
        	
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
