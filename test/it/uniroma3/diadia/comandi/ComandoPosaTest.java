package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {

	private Partita partitaTest;
	private ComandoPosa comandoPosa;
	private Attrezzo attrezzoTest;
	private IO io;
	
	@Before
	public void setUp() throws Exception {
		this.partitaTest = new Partita();
		this.io = new IOConsole();
		this.comandoPosa = new ComandoPosa();
		this.attrezzoTest = new Attrezzo("attrezzoTest", 5);
		this.partitaTest.getGiocatore().getBorsa().addAttrezzo(attrezzoTest);
	}

	@Test
	public void testEseguiAttrezzoEsistenteInBorsa() {
		this.comandoPosa.setParametro(attrezzoTest.getNome());
		this.comandoPosa.esegui(this.partitaTest, this.io);
		assertTrue(this.partitaTest.getStanzaCorrente().hasAttrezzo(attrezzoTest.getNome()));
	}

}
