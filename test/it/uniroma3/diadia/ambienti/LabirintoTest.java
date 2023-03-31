package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class LabirintoTest {

	private Labirinto labirintoTest;
	private Stanza stanzaTest;
	
	@Before
	public void setUp() {
		this.labirintoTest = new Labirinto();
		this.stanzaTest = new Stanza("stanzaTest");
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertNotNull(this.labirintoTest.getStanzaVincente());
	}

	@Test
	public void testGetStanzaCorrente() {
		this.labirintoTest.setStanzaCorrente(stanzaTest);
		assertEquals(this.stanzaTest.getNome(), this.labirintoTest.getStanzaCorrente().getNome());
	}

}
