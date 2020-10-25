package fr.bengi.natsystem.bataille;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import fr.bengi.natsystem.bataille.models.Carte;

public class InitJeuCarteTest {

	@Test
	public void testJeu52Cartes() {
		InitJeuCarte initJeuCarte = new InitJeuCarteImpl();
		
		assertEquals(52, initJeuCarte.jeu52Cartes().size());
	}
	
	@Test
	public void testCarteUnique() {
		InitJeuCarte initJeuCarte = new InitJeuCarteImpl();
		List<Carte> listCarte = new ArrayList<Carte>(initJeuCarte.jeu52Cartes());

		Set<Carte> setCarte = new HashSet<Carte>();
		
		for (Carte carte : listCarte) {
			setCarte.add(carte);
		}
		
		assertEquals(52, setCarte.size());
	}

}
