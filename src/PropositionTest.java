package model;

import static org.junit.Assert.assertEquals;

import junit.framework.TestCase;

class PropositionTest{
	
	public void testMot(){
		Proposition prop1 = new Proposition("Scorpion","Balance");
		Proposition prop2 = new Proposition("Balance","Balance");
		
		assertEquals(Proposition.traiterReponse(prop1),"Scorpion");
		assertEquals(Proposition.traiterReponse(prop2),"Balance");
	}
}
