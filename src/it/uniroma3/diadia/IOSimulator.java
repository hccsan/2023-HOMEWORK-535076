package it.uniroma3.diadia;

import java.util.*;

public class IOSimulator implements IO {

	private List<String> righeLette;
	private int indiceRightLette;
	
	public List<String> getMessaggiProdotti() {
		return messaggiProdotti;
	}
	
	public void setMessaggiProdotti(List<String> messaggiProdotti) {
		this.messaggiProdotti = messaggiProdotti;
	}
	
	public List<String> messaggiProdotti;	// provare con la mappa
	private int indiceMessaggiProdotti;
	private int indiceMessaggiMostrati;
	
	public IOSimulator(List<String> righeDaLeggere) {
		this.righeLette = righeDaLeggere;
		this.indiceRightLette = 0;
		this.indiceMessaggiMostrati = 0;
		this.messaggiProdotti = new ArrayList<String>();
	}
	
	@Override
	public void mostraMessaggio(String messaggio) {
		this.messaggiProdotti.add(this.indiceMessaggiProdotti, messaggio);
		this.indiceMessaggiProdotti++;
	}

	@Override
	public String leggiRiga() {
		String riga = null;
		
		riga = this.righeLette.get(indiceRightLette);
		this.indiceRightLette++;
		return riga;
	}
	
	public String nextMessaggio() {
		String next = this.messaggiProdotti.get(indiceMessaggiMostrati);
		this.indiceMessaggiMostrati++;
		return next;
	}
	
	public boolean hasNextMessaggio() {
		return this.indiceMessaggiMostrati < this.indiceMessaggiProdotti;
	}
	

}
