package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;

public class ComandoVaiTest {

	private Stanza stanza1;
	private Stanza stanza2;
	private ComandoVai vai;
	private Partita partita1;
//	private Partita partita2;
	List<String> rightDaLeggere;
	List<String> rightDaLeggere2;
	Labirinto labirinto;
	Labirinto labirinto2;
	private IO io;
	
	@Before
	public void setUp() throws Exception {
		io = new IOConsole();
		stanza1 = new Stanza("aula 1");
		stanza2 = new Stanza("aula 2");
		vai = new ComandoVai();
		labirinto = Labirinto.labirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		partita1 = new Partita(labirinto);
		rightDaLeggere = new ArrayList<>();
		rightDaLeggere2 = new ArrayList<>();
	}

	@Test
	public void testVaiNull() {
		partita1.setStanzaCorrente(stanza1);
		vai.esegui(partita1, io);
		assertEquals(stanza1, partita1.getStanzaCorrente());
	}

	@Test
	public void testVaiDirezioneEsistente() {
		partita1.setStanzaCorrente(stanza1);
		stanza1.impostaStanzaAdiacente("sud-ovest", stanza2);
		vai.setParametro("sud-ovest");
		vai.esegui(partita1, io);
		assertEquals(stanza2, partita1.getStanzaCorrente());
	}

	@Test
	public void testVaiDirezioneInesistente() {
		partita1.setStanzaCorrente(stanza1);
		stanza1.impostaStanzaAdiacente("sud-ovest", stanza2);
		vai.setParametro("in fondo a destra");
		vai.esegui(partita1, io);
		assertNotEquals(stanza2, partita1.getStanzaCorrente());
	}
}
