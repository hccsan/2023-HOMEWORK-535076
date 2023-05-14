package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {

	private Partita partitaTest;
	private ComandoPrendi comandoPrendi;
	private Attrezzo attrezzoTest;
	private IO io;
	
	@Before
	public void setUp() throws Exception {
		this.partitaTest = new Partita();
		this.comandoPrendi = new ComandoPrendi();
		this.io = new IOConsole();
		this.attrezzoTest = new Attrezzo("attrezzoTest", 5);
		this.partitaTest.getStanzaCorrente().addAttrezzo(attrezzoTest);
	}

	@Test
	public void testEseguiAttrezzoEsistente() {
		this.comandoPrendi.setParametro(attrezzoTest.getNome());
		this.comandoPrendi.esegui(this.partitaTest, this.io);
		assertTrue(this.partitaTest.getGiocatore().getBorsa().hasAttrezzo(attrezzoTest.getNome()));
	}
	
	@Test
	public void testEseguiAttrezzoNull() {
		this.comandoPrendi.setParametro(null);
		this.comandoPrendi.esegui(this.partitaTest, this.io);
		assertNull(this.partitaTest.getGiocatore().getBorsa().getAttrezzo(null));
	}
}
