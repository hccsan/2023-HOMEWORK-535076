package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	
	private Borsa borsaTest;
	private Attrezzo piuma;
	private Attrezzo bastone;
	private Attrezzo piombo;
	private Attrezzo libro;
	private Set<Attrezzo> insieme;
//	private static final String DESCRIZIONE_BORSA = "";

	@Before
	public void setUp() {
		this.borsaTest = new Borsa();
		this.piuma = new Attrezzo("piuma", 1);
		this.bastone = new Attrezzo("bastone", 5);
		this.piombo = new Attrezzo("piombo", 10);
		this.libro = new Attrezzo("libro", 5);
		this.insieme = new HashSet<Attrezzo>();
		this.insieme.add(piombo);
		this.insieme.add(bastone);
		this.insieme.add(piuma);
		this.insieme.add(libro);	
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
		this.borsaTest.addAttrezzo(piuma);
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
	
	@Test
	public void testOrdinatoPerPeso() {
		this.borsaTest.getContenutoOrdinatoPerPeso();
		
	}
	
	@Test
	public void testOrdinatoPerNome() {
		this.borsaTest.getContenutoOrdinatoPerNome();
		
	}
	
	@Test
	public void testRaggruppatoPerPeso() {
		this.borsaTest.getContenutoRaggruppatoPerPeso();
	}

}
