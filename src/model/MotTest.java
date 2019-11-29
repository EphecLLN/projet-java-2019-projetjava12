package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MotTest {

	@Test
	void test() {
		Mot test1 = new Mot("abrise");
		assertEquals("ABRISE", test1.getValeur());	
	}

}
