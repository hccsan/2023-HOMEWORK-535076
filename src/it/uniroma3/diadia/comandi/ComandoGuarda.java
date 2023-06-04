package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {

	private static final String NOME = "guarda";
	
	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio("Stato della partita: ");
		this.getIo().mostraMessaggio("CFU rimanenti: "+ partita.getGiocatore().getCfu());
		this.getIo().mostraMessaggio("Stanza corrente: " + partita.getStanzaCorrente().getDescrizione());
	}

	@Override
	public String getNome() {
		return NOME;
	}
}
