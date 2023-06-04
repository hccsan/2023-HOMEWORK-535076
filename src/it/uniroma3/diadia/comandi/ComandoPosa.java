package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando {

	private String nomeAttrezzo;
	private static final String NOME = "posa";
	
	@Override
	public void esegui(Partita partita) {
		if (nomeAttrezzo == null)
			this.getIo().mostraMessaggio("Quale attrezzo vuoi posare?");
		Attrezzo attrezzoDaPosare = null;
		attrezzoDaPosare = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if (attrezzoDaPosare == null) 
			this.getIo().mostraMessaggio("Attrezzo inesistente");
		else {
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare);
			this.getIo().mostraMessaggio("Attrezzo " + nomeAttrezzo + " posato!");
		}
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
