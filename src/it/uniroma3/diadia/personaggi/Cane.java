package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/*
 * morde! Ogni morso diminuisce i CFU del protagonista
 */

public class Cane extends AbstractPersonaggio {
	
	private static String MESSAGGIO_CANE = "";
	private static String CIBO_PREFERITO = "osso";

	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}
	
	@Override
	public String agisci(Partita partita) {
		String msg = MESSAGGIO_CANE;
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return msg;
	}
	
	/*
	 * un cane riceve un regalo: accetta il suo cibo preferito, e butta
	 * a terra un attrezzo; ma morde e toglie un CFU per tutto il resto
	 */

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		StringBuilder risposta = new StringBuilder("Bau grazie per avermi regalato ");
		
		if (attrezzo.getNome().equals(CIBO_PREFERITO)) {
			risposta.append("il mio cibo preferito");
			partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("Collare", 2));
		} else {
			risposta.append(attrezzo.getNome() + "non e' mio cibo preferito bau!");
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		}
		return risposta.toString();
	}

}
