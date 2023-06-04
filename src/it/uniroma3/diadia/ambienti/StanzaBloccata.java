package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	private String attrezzoSbloccante;
	private Direzione direzioneBloccata;
	
	public StanzaBloccata(String nome, String attrezzoSbloccante, Direzione direzioneBloccata) {
		super(nome);
		this.attrezzoSbloccante = attrezzoSbloccante;
		this.direzioneBloccata = direzioneBloccata;
	}
	
	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {
		if (direzioneBloccata.equals(direzione) && !super.hasAttrezzo(attrezzoSbloccante))
			return this;
		return super.getStanzaAdiacente(direzione);
	}

	
	@Override
	public String getDescrizione() {
		String bloccata = "Stanza bloccata nella direzione: " + direzioneBloccata + "\nPrendi il" +
	attrezzoSbloccante + "e posalo nella sttanza";
		
		if (!this.hasAttrezzo(attrezzoSbloccante))
			return bloccata;
		return super.getDescrizione();
	}
}
