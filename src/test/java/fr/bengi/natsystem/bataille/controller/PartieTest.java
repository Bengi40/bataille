package fr.bengi.natsystem.bataille.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.bengi.natsystem.bataille.InitJeuCarte;
import fr.bengi.natsystem.bataille.InitJeuCarteImpl;
import fr.bengi.natsystem.bataille.models.Carte;
import fr.bengi.natsystem.bataille.models.Joueur;

public class PartieTest {

	@Test
	public void testMelangeCarte() {
		Partie partie = new PartieImpl();
		InitJeuCarte jeuCarte = new InitJeuCarteImpl();
		List<Carte> listJeuCarte = new ArrayList<Carte>(jeuCarte.jeu52Cartes());

		List<Carte> cartePartie = new ArrayList<Carte>(partie.initTasCarte());
		List<Carte> carteMelanger = partie.melangeCarte(cartePartie);

		boolean isMixed = true;
		int melange = 0;
		int tailleJeuDeCarte = listJeuCarte.size();
		int tauxAcceptationMalanger = tailleJeuDeCarte * 3 / 4;

		for (int i = 0; i < listJeuCarte.size(); i++) {
			if (listJeuCarte.get(i).toString().equals(carteMelanger.get(i).toString())) {
				melange--;
			} else {
				melange++;
			}
		}
		if (melange > tauxAcceptationMalanger) {
			isMixed = true;
		} else {
			isMixed = false;
		}
		assertEquals(true, isMixed);
	}

	@Test
	public void testDistribution() {
		Partie partie = new PartieImpl(4);
		partie.distribution(partie.initTasCarte());
		int nbCarteParJoueur = partie.getJoueurs().get(0).getMainJoueur().size();
		assertEquals(13, nbCarteParJoueur);
	}

	@Test
	public void testTirageCarte() {
		Partie partie = new PartieImpl(1);
		
		Carte carte1 = new Carte();
		carte1.setNom("2");
		carte1.setCouleur("pique");
		carte1.setValeur(2);
		
		Carte carte2 = new Carte();
		carte2.setNom("10");
		carte2.setCouleur("pique");
		carte2.setValeur(10);
		
		List<Carte> cartes = new ArrayList<Carte>();
		cartes.add(carte1);
		cartes.add(carte2);
		
		Joueur joueur1 = new Joueur();
		joueur1.setNom("joueur1");
		joueur1.setMainJoueur(cartes);
		
		List<Joueur> joueurs = new ArrayList<Joueur>();
		joueurs.add(joueur1);
		
		partie.setJoueurs(joueurs);
		
		partie.tirageCarte();
		
		assertEquals("2 de pique", joueur1.getCarteTapis().toString());
	}

	@Test
	public void testComparaisonDeuxCartes() {
		Partie partie = new PartieImpl();
		Carte carte1 = new Carte();
		carte1.setValeur(1);

		Carte carte2 = new Carte();
		carte2.setValeur(10);

		Carte cartePlusForte = new Carte();
		cartePlusForte = partie.comparaisonDeuxCartes(carte1, carte2);

		assertEquals(carte2, cartePlusForte);
	}

	@Test
	public void testComparaisonCarte() {
		Partie partie = new PartieImpl();

		Joueur joueur1 = new Joueur();
		Carte carte1 = new Carte();
		carte1.setValeur(1);
		joueur1.setNom("joueur1");
		joueur1.setCarteTapis(carte1);

		Joueur joueur2 = new Joueur();
		Carte carte2 = new Carte();
		carte2.setValeur(10);
		joueur2.setCarteTapis(carte2);

		List<Joueur> joueurs = new ArrayList<Joueur>();
		joueurs.add(joueur1);
		joueurs.add(joueur2);
		joueur2.setNom("joueur2");
		partie.setJoueurs(joueurs);

		Joueur joueurPlusFort = new Joueur();
		joueurPlusFort = partie.comparaisonCarte();

		assertEquals("joueur2", joueurPlusFort.getNom());
	}

	@Test
	public void testAttributionDesCartesAuPlusFort() {
		Partie partie = new PartieImpl();

		Carte carte1 = new Carte();
		carte1.setNom("2");
		carte1.setCouleur("pique");
		carte1.setValeur(2);
		
		List<Carte> cartes1 = new ArrayList<Carte>();
		cartes1.add(carte1);
		
		Joueur joueur1 = new Joueur();
		joueur1.setNom("joueur1");
		joueur1.setCarteTapis(carte1);
		joueur1.setMainJoueur(cartes1);
		
		Carte carte2 = new Carte();
		carte2.setNom("10");
		carte2.setCouleur("pique");
		carte2.setValeur(10);
		List<Carte> cartes2 = new ArrayList<Carte>();
		cartes2.add(carte2);
		
		Joueur joueur2 = new Joueur();
		joueur2.setNom("joueur2");
		joueur2.setCarteTapis(carte2);
		joueur2.setMainJoueur(cartes2);

		List<Joueur> joueurs = new ArrayList<Joueur>();
		joueurs.add(joueur1);
		joueurs.add(joueur2);
		partie.setJoueurs(joueurs);

		Joueur joueurPlusFort = new Joueur();
		joueurPlusFort.setNom("joueur2");
			
		partie.attributionDesCartes(joueurPlusFort);

		assertEquals(2, joueur2.getMainJoueur().size());
	}
	
	@Test
	public void testAttributionDesCartesAuPlusFaible() {
		Partie partie = new PartieImpl();

		Carte carte1 = new Carte();
		carte1.setNom("2");
		carte1.setCouleur("pique");
		carte1.setValeur(2);
		
		List<Carte> cartes1 = new ArrayList<Carte>();
		cartes1.add(carte1);
		
		Joueur joueur1 = new Joueur();
		joueur1.setNom("joueur1");
		joueur1.setCarteTapis(carte1);
		joueur1.setMainJoueur(cartes1);
		
		Carte carte2 = new Carte();
		carte2.setNom("10");
		carte2.setCouleur("pique");
		carte2.setValeur(10);
		List<Carte> cartes2 = new ArrayList<Carte>();
		cartes2.add(carte2);
		
		Joueur joueur2 = new Joueur();
		joueur2.setNom("joueur2");
		joueur2.setCarteTapis(carte2);
		joueur2.setMainJoueur(cartes2);

		List<Joueur> joueurs = new ArrayList<Joueur>();
		joueurs.add(joueur1);
		joueurs.add(joueur2);
		partie.setJoueurs(joueurs);

		Joueur joueurPlusFort = new Joueur();
		joueurPlusFort.setNom("joueur2");
			
		partie.attributionDesCartes(joueurPlusFort);

		assertEquals(0, joueur1.getMainJoueur().size());
	}

	@Test
	public void testInitCarteTapis() {
		Partie partie = new PartieImpl();

		Joueur joueur1 = new Joueur();
		Carte carte1 = new Carte();
		carte1.setNom("2");
		carte1.setCouleur("pique");
		carte1.setValeur(2);
		joueur1.setNom("joueur1");
		joueur1.setCarteTapis(carte1);

		Joueur joueur2 = new Joueur();
		Carte carte2 = new Carte();
		carte2.setNom("10");
		carte2.setCouleur("pique");
		carte2.setValeur(10);
		joueur2.setCarteTapis(carte2);

		List<Joueur> joueurs = new ArrayList<Joueur>();
		joueurs.add(joueur1);
		joueurs.add(joueur2);

		partie.initCarteTapis(joueurs);

		assertNull(joueur1.getCarteTapis());
	}

}
