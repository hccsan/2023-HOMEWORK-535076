package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	private String nomeAttrezzo;
	private static final String NOME = "prendi";
	
	@Override
	public void esegui(Partita partita, IO io) {
		if (nomeAttrezzo == null)
			io.mostraMessaggio("Quale attrezzo vuoi prendere?");
		Attrezzo attrezzoDaPrendere = null;
		attrezzoDaPrendere = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if (attrezzoDaPrendere == null) 
			io.mostraMessaggio("Attrezzo inesistente");
		else {
			partita.getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
			partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere);
			io.mostraMessaggio("Attrezzo " + nomeAttrezzo + " preso!");
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getNome() {
		return NOME;
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
}
