package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	private StanzaBuia stanzaBuiaTest;
	private static final String DESCRIZIONE_STANZA = "StanzaBuia\n" + 
			"Uscite: \n" + 
			"Attrezzi nella stanza: attrezzoTest (1kg) ";
	private Attrezzo attrezzoTest;
	
	@Before
	public void setUp() throws Exception {
		this.attrezzoTest = new Attrezzo("attrezzoTest", 1);
		this.stanzaBuiaTest = new StanzaBuia("StanzaBuia", attrezzoTest.getNome());
		
	}

	@Test
	public void testGetDescrizioneNonPresente() {
		assertEquals(stanzaBuiaTest.DESCRIZIONE_STANZA_BUIA, this.stanzaBuiaTest.getDescrizione());
	}

	@Test
	public void testGetDescrizioneConAttrezzo() {
		stanzaBuiaTest.addAttrezzo(attrezzoTest);
		assertEquals(DESCRIZIONE_STANZA, this.stanzaBuiaTest.getDescrizione());
	}
	
}
