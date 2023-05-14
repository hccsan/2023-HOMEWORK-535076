package it.uniroma3.diadia.ambienti;

import java.util.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder extends Labirinto {
	
	private Labirinto labirinto;
	private Stanza ultimaStanzaAggiornata;
	private Map<String, Stanza> listaStanze;
	
	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.listaStanze = new HashMap<String, Stanza>();
	}

	public Map<String, Stanza> getListaStanze() {
		return this.listaStanze;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
		Stanza iniziale = new Stanza(stanzaIniziale);
		this.labirinto.setStanzaIniziale(iniziale);
		this.UltimaStanzaAggiuntaEAggiorna(iniziale);
		return this;
	}
	
	public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
		Stanza vincente = new Stanza(stanzaVincente);
		this.labirinto.setStanzaIniziale(vincente);
		this.UltimaStanzaAggiuntaEAggiorna(vincente);
		return this;
	}
	
	public LabirintoBuilder addStanza(String stanza) {
		Stanza s = new Stanza(stanza);
		this.UltimaStanzaAggiuntaEAggiorna(s);
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
		Attrezzo a = new Attrezzo(nomeAttrezzo, peso);
		if (this.ultimaStanzaAggiornata==null)
			return this;
		this.ultimaStanzaAggiornata.addAttrezzo(a);
		return this;
	}
	
	public LabirintoBuilder addAdiacenza (String stanzaCorrente, String stanzaAdiacente, String direzione) {
		Stanza corrente = this.listaStanze.get(stanzaCorrente);
		Stanza adiacente = this.listaStanze.get(stanzaAdiacente);
		corrente.impostaStanzaAdiacente(direzione, adiacente);
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
		Stanza stanza = new StanzaBloccata(nome, attrezzoSbloccante, direzioneBloccata);
		this.UltimaStanzaAggiuntaEAggiorna(stanza);
		return this;
	}
	
	public void UltimaStanzaAggiuntaEAggiorna(Stanza stanza) { 
		this.ultimaStanzaAggiornata = stanza;
		this.listaStanze.put(stanza.getNome(), stanza);
	}
	
}
