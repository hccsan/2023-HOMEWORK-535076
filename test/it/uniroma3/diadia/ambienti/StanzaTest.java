package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;

public class StanzaTest {

	private Stanza stanzaTest;
	private Attrezzo attrezzoTest;
	
	@Before
	public void setUp() {
		this.stanzaTest = new Stanza ("stanzaTest");
		this.attrezzoTest = new Attrezzo ("attrezzoTest", 1);
	}
	
	@Test
	public void testGetNome() {
		assertNotNull(this.stanzaTest.getNome());
	}

	@Test
	public void testAddAttrezzo() {
		this.stanzaTest.addAttrezzo(attrezzoTest);
		assertTrue(this.stanzaTest.hasAttrezzo("attrezzoTest"));
	}

	@Test
	public void testHasAttrezzo() {
		assertFalse(this.stanzaTest.hasAttrezzo(null));
	}

	@Test
	public void testGetAttrezzo() {
		this.stanzaTest.addAttrezzo(attrezzoTest);
		assertEquals("attrezzoTest", this.stanzaTest.getAttrezzo("attrezzoTest").getNome());
	}

}
