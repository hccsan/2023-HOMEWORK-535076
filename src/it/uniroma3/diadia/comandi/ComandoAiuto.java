package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
 * Stampa informazioni di aiuto.
 */


public class ComandoAiuto implements Comando {

	static final private String[] elencoComandi = {"vai", "prendi", "posa", "guarda", "aiuto", "fine"};
	private static final String NOME = "aiuto";
	
	@Override
	public void esegui(Partita partita, IO io) {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
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
