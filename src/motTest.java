package project;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import project.mot;

class motTest {

	@Test
	void test() {
		mot test1 = new mot("calendrier");
		
		assertEquals(mot.formatMot("calendrier"), "CALENDRIER");
	}

}
