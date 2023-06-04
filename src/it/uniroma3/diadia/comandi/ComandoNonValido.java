package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {

	private static final String NOME = "non_valido";
	
	@Override
	public void esegui(Partita partita) {
		
		this.getIo().mostraMessaggio("Comando non valido!");
	}

	@Override
	public String getNome() {
		return NOME;
	}
}
