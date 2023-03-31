package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	
	private Borsa borsaTest;
	private Attrezzo palla;
	private Attrezzo bastone;
	

	@Before
	public void setUp() {
		this.borsaTest = new Borsa();
		this.palla = new Attrezzo("palla", 1);
		this.bastone = new Attrezzo("bastone", 5);
	}
	
	@Test
	public void testGetPesoMax() {
		this.borsaTest = new Borsa(10);
		assertEquals(10, this.borsaTest.getPesoMax());
	}

	@Test
	public void testGetAttrezzo() {
		this.borsaTest.addAttrezzo(bastone);
		assertNotNull(this.borsaTest.getAttrezzo("bastone"));
	}

	@Test
	public void testGetPeso() {
		this.borsaTest.addAttrezzo(palla);
		this.borsaTest.addAttrezzo(bastone);
		assertNotEquals(10, this.borsaTest.getPeso());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(this.borsaTest.isEmpty());
	}

	@Test
	public void testHasAttrezzo() {
		assertFalse(this.borsaTest.hasAttrezzo("palla"));
	}

}
