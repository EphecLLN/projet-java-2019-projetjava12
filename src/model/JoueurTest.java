package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JoueurTest {

	@Test
	void testPseudo() {
		Joueur joueur1= new Joueur();
		joueur1.setPseudo("Patrick");
		assertEquals("Patrick",joueur1.getPseudo());
	}
	@Test 
	void testToString() {
		Joueur joueur1= new Joueur();
		joueur1.setPseudo("Patrick");
		joueur1.addScore();
		assertEquals("Joueur =Patrick, score=1",joueur1.toString());
		
	}
	@Test
	void testScore() {
		Joueur joueur1= new Joueur();
		joueur1.addScore();
		joueur1.addScore();
		assertEquals(2,joueur1.getScore());
		
	}

}
