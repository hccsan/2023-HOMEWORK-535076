package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PartitaTest {
	
	private Partita partitaTest;
//	private Stanza stanzaTest;
	
	
	@Before
	public void setUp() {
		this.partitaTest = new Partita();
//		this.stanzaTest = new Stanza("stanzaTest");
	}

//	@Test
//	public void testGetStanzaVincente() {
//		assertNotNull(this.partitaTest.getStanzaVincente());
//	}
//
//	@Test
//	public void testGetStanzaCorrente() {
//		this.partitaTest.setStanzaCorrente(stanzaTest);
//		assertEquals("stanzaTest", this.partitaTest.getStanzaCorrente().getNome());
//	}

	@Test
	public void testVinta() {
		assertFalse(this.partitaTest.vinta());
	}

//	@Test
//	public void testIsFinita() {
//		this.partitaTest.setCfu(0);
//		assertTrue(this.partitaTest.isFinita());
//	}
//
//	@Test
//	public void testGetCfu() {
//		this.partitaTest.setCfu(0);
//		assertNotEquals(10, this.partitaTest.getCfu());
//	}

}
