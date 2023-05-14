package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {

	private String nomeAttrezzo;
	private static final String NOME = "posa";
	
	@Override
	public void esegui(Partita partita, IO io) {
		if (nomeAttrezzo == null)
			io.mostraMessaggio("Quale attrezzo vuoi posare?");
		Attrezzo attrezzoDaPosare = null;
		attrezzoDaPosare = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if (attrezzoDaPosare == null) 
			io.mostraMessaggio("Attrezzo inesistente");
		else {
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare);
			io.mostraMessaggio("Attrezzo " + nomeAttrezzo + " posato!");
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
