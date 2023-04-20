package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	
	private static final String STANZA_ADIACENTE_LIBERA = "stanzaAdiacenteLibera";
	private static final String STANZA_ADIACENTE_BLOCCATA = "stanzaAdiacenteBloccata";
	private static final String DIREZIONE_BLOCCATA = "DirBloccata";
	private static final String DIREZIONE_LIBERA = "DirLibera";
	private static final String CHIAVE_TEST = "chiaveTest";
	private static final String STANZA_BLOCCATA = "StanzaBloccata";
	
	private StanzaBloccata stanzaBloccata;
	private Attrezzo chiaveTest;

	@Before
	public void setUp() throws Exception {
		this.chiaveTest = new Attrezzo(CHIAVE_TEST, 1);
		StanzaBloccata stanzaBloccata = new StanzaBloccata(STANZA_BLOCCATA, DIREZIONE_BLOCCATA, CHIAVE_TEST);
		this.stanzaBloccata = stanzaBloccata;
		
	}

	private void setStanzaAdiacenti(Stanza stanzaBloccata) {
		Stanza stanzaAdiacenteLibera = new Stanza(STANZA_ADIACENTE_LIBERA);
		Stanza stanzaAdiacenteBloccata = new Stanza(STANZA_ADIACENTE_BLOCCATA);
		stanzaBloccata.impostaStanzaAdiacente(DIREZIONE_BLOCCATA, stanzaAdiacenteBloccata);
		stanzaBloccata.impostaStanzaAdiacente(DIREZIONE_LIBERA, stanzaAdiacenteLibera);
	}
	
	@Test
	public void testGetStanzaAdiacenteBloccata() {
		setStanzaAdiacenti(this.stanzaBloccata);
		assertEquals(this.stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente(DIREZIONE_BLOCCATA));
	}
	
	@Test
	public void testGetStanzaAdiacenteSbloccata() {
		setStanzaAdiacenti(this.stanzaBloccata);
		this.stanzaBloccata.addAttrezzo(chiaveTest);
		assertEquals(STANZA_ADIACENTE_BLOCCATA, this.stanzaBloccata.getStanzaAdiacente(DIREZIONE_BLOCCATA).getNome());;
	}
	
	@Test
	public void testGetStanzaAdiacenteLibera() {
		setStanzaAdiacenti(this.stanzaBloccata);
		assertEquals(STANZA_ADIACENTE_LIBERA, this.stanzaBloccata.getStanzaAdiacente(DIREZIONE_LIBERA).getNome());
	}
	
	@Test
	public void testGetAttrezzoInesistente() {
		assertNull(this.stanzaBloccata.getAttrezzo("inesistente"));		
	}
}
