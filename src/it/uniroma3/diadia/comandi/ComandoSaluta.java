package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando {
	

	@Override
	public void esegui(Partita partita) {
		if(partita.getStanzaCorrente().getPersonaggio()!=null)
		this.getIo().mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().saluta());
	else 
		this.getIo().mostraMessaggio("Non c'e' alcun personaggio in questa stanza!");
	}
}
