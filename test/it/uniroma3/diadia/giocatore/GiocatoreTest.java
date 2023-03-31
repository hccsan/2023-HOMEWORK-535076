package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class GiocatoreTest {

	private Giocatore giocatoreTest;
	private int cfu = 0;
	private Borsa borsaTest;
	private Attrezzo attrezzoTest;
	
	@Before
	public void setUp() throws Exception {
		this.giocatoreTest = new Giocatore();
		this.borsaTest = new Borsa();
		this.attrezzoTest = new Attrezzo("attrezzoTest", 1);
	}

	@Test
	public void testGetBorsa() {
		this.borsaTest.addAttrezzo(attrezzoTest);
		assertNotNull(this.giocatoreTest.getBorsa());
	}

	@Test
	public void testGetCfu() {
		this.giocatoreTest.setCfu(cfu);
		assertEquals(0, this.giocatoreTest.getCfu());
	}

}
