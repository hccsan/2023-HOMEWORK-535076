package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

	private String nomeAttrezzoPerVedere;
	public final String DESCRIZIONE_STANZA_BUIA = "qui c'è buio pesto";
	
	public StanzaBuia(String nome, String nomeAttrezzoPerVedere) {
		super(nome);
		this.nomeAttrezzoPerVedere = nomeAttrezzoPerVedere;
	}
	
	@Override
	public String getDescrizione() {
		if (!super.hasAttrezzo(nomeAttrezzoPerVedere))
			return DESCRIZIONE_STANZA_BUIA;
		return super.getDescrizione();
	}
	

}
