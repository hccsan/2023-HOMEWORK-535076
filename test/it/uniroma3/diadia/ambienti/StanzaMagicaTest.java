package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

	private static final String ATTREZZO_DA_MODIFICARE = "attrezzoTest2";
	private static final String ATTREZZO_TEST = "attrezzoTest";
	private static final int SOGLIA_MAGICA = 3;
	private static final String STANZA_MAGICA_TEST = "StanzaMagicaTest";
	
	private StanzaMagica stanzaMagicaTest;
	private Attrezzo attrezzoTest;
	private Attrezzo attrezzoDaModificare;
	
	@Before
	public void setUp() throws Exception {
		this.stanzaMagicaTest = new StanzaMagica(STANZA_MAGICA_TEST, SOGLIA_MAGICA);
		this.attrezzoTest = new Attrezzo("attrezzoTest", 1);
		this.attrezzoDaModificare = new Attrezzo("attrezzoTest2", 1);
	}

	@Test
	public void testAddAttrezzoOltreSogliaMagica() {
		for (int i = 0; i < SOGLIA_MAGICA; i++)
			this.stanzaMagicaTest.addAttrezzo(attrezzoTest);
		this.stanzaMagicaTest.addAttrezzo(attrezzoDaModificare);
		String nomeAttrezzoModificato = new StringBuilder(ATTREZZO_DA_MODIFICARE).reverse().toString();
		Attrezzo attrezzoModificato = this.stanzaMagicaTest.getAttrezzo(nomeAttrezzoModificato);
		assertNotNull(attrezzoModificato);
		assertEquals(2, attrezzoModificato.getPeso());
		assertFalse(this.stanzaMagicaTest.hasAttrezzo(ATTREZZO_DA_MODIFICARE));
	}
	
	@Test
	public void testAddAttrezzoSingolo() {
		Attrezzo attrezzoSemplice = this.attrezzoTest;
		this.stanzaMagicaTest.addAttrezzo(attrezzoSemplice);
		assertEquals(attrezzoSemplice, this.stanzaMagicaTest.getAttrezzo(ATTREZZO_TEST));
	}

}
