package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando {

	private String nomeAttrezzo;
	private static final String NOME = "prendi";
	
	@Override
	public void esegui(Partita partita) {
		if (nomeAttrezzo == null)
			this.getIo().mostraMessaggio("Quale attrezzo vuoi prendere?");
		Attrezzo attrezzoDaPrendere = null;
		attrezzoDaPrendere = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if (attrezzoDaPrendere == null) 
			this.getIo().mostraMessaggio("Attrezzo inesistente");
		else {
			partita.getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
			partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere);
			this.getIo().mostraMessaggio("Attrezzo " + nomeAttrezzo + " preso!");
		}
	}

	@Override
	public String getNome() {
		return NOME;
	}
}
