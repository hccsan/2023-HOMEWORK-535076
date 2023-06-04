package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

public class Labirinto {

	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;

	public Labirinto(String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException {
		CaricatoreLabirinto c = new CaricatoreLabirinto(nomeFile);
		c.carica();
		this.stanzaIniziale = c.getStanzaIniziale();
		this.stanzaVincente = c.getStanzaVincente();
	}
	
	public static LabirintoBuilder newBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		return new LabirintoBuilder(labirinto);
	}
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaIniziale = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaIniziale;
	}

	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
	
	/*
	 * static nested class LabirintoBuilder=======
	 * ===========================================
	 * ===========================================
	 * ===========================================
	 * ===========================================
	 */

	public static class LabirintoBuilder {
		
		public static  class Pippo {
			//another useless nested class
		}
		
		private Labirinto labirinto;
		private Stanza ultimaAggiunta;
		private Map<String, Stanza> listaStanze;
		
		public LabirintoBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
			this.labirinto = new Labirinto(labirinto);
			this.listaStanze = new HashMap<>();
		}

		public Map<String, Stanza> getListaStanze() {
			return this.listaStanze;
		}

		public Labirinto getLabirinto() {
			return this.labirinto;
		}
		
		public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
			Stanza iniziale = new Stanza(stanzaIniziale);
			this.labirinto.setStanzaCorrente(iniziale);
			this.UltimaStanzaAggiuntaEAggiorna(iniziale);
			return this;
		}
		
		public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
			Stanza vincente = new Stanza(stanzaVincente);
			this.labirinto.setStanzaVincente(vincente);
			this.UltimaStanzaAggiuntaEAggiorna(vincente);
			return this;
		}
		

		
		public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
			Attrezzo a = new Attrezzo(nomeAttrezzo, peso);
			this.ultimaAggiunta.addAttrezzo(a);
			return this;
		}
		
		public LabirintoBuilder addAdiacenza (String partenza, String adiacente, Direzione direzione) {
			Stanza stanzaPartenza = this.listaStanze.get(partenza);
			Stanza stanzaAdiacente = this.listaStanze.get(adiacente);
			stanzaPartenza.impostaStanzaAdiacente(direzione, stanzaAdiacente);
			return this;
		}
		
		public LabirintoBuilder addStanza(String stanza) {
			Stanza s = new Stanza(stanza);
			this.UltimaStanzaAggiuntaEAggiorna(s);
			return this;
		}
		
		public LabirintoBuilder addMago(String nome, String presentazione, Attrezzo attrezzo) {
			Mago m = new Mago(nome, presentazione, attrezzo);
			if (this.ultimaAggiunta==null)
				return this;
			this.ultimaAggiunta.setPersonaggio(m);
			return this;
		}
		
		public LabirintoBuilder addCane(String nome, String presentazione) {
			Cane c = new Cane(nome, presentazione);
			if (this.ultimaAggiunta==null)
				return this;
			this.ultimaAggiunta.setPersonaggio(c);
			return this;
		}
		
		public LabirintoBuilder addStrega(String nome, String presentazione) {
			Strega s = new Strega(nome, presentazione);
			if (this.ultimaAggiunta==null)
				return this;
			this.ultimaAggiunta.setPersonaggio(s);
			return this;
		}
		
		public LabirintoBuilder addStanzaMagica(String nome) {
			Stanza stanza = new StanzaMagica(nome);
			this.UltimaStanzaAggiuntaEAggiorna(stanza);
			return this;
		}
		
		public LabirintoBuilder addStanzaMagica(String nome, int soglia) {
			Stanza stanza = new StanzaMagica(nome, soglia);
			this.UltimaStanzaAggiuntaEAggiorna(stanza);
			return this;
		}
		
		public LabirintoBuilder addStanzaBuia(String nome, String attrezzoPerVedere) {
			Stanza stanza = new StanzaBuia(nome,attrezzoPerVedere);
			this.UltimaStanzaAggiuntaEAggiorna(stanza);
			return this;
		}
		
		public LabirintoBuilder addStanzaBloccata(String nome, String attrezzoSbloccante, String direzioneBloccata) {
			Stanza stanza = new StanzaBloccata(nome, attrezzoSbloccante, Direzione.valueOf(direzioneBloccata));
			this.UltimaStanzaAggiuntaEAggiorna(stanza);
			return this;
		}
		
		public void UltimaStanzaAggiuntaEAggiorna(Stanza stanza) { 
			this.ultimaAggiunta = stanza;
			this.listaStanze.put(stanza.getNome(), stanza);
		}
		
	}
	
}
