package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	private static final String NOME = "guarda";
	
	@Override
	public void esegui(Partita partita, IO io) {
		io.mostraMessaggio("Stato della partita: ");
		io.mostraMessaggio("CFU rimanenti: "+ partita.getGiocatore().getCfu());
		io.mostraMessaggio("Stanza corrente: " + partita.getStanzaCorrente().getDescrizione());
	}

	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public String getNome() {
		return NOME;
	}

	@Override
	public String getParametro() {
		return null;
	}
}
