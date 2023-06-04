package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Stampa informazioni di aiuto.
 */


public class ComandoAiuto extends AbstractComando {

	static final private String[] elencoComandi = {"vai", "prendi", "posa", "guarda", "aiuto", "fine"};
	private static final String NOME = "aiuto";
	
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			this.getIo().mostraMessaggio(elencoComandi[i]+" ");
		this.getIo().mostraMessaggio("");
	}

	@Override
	public String getNome() {
		return NOME;
	}
}
