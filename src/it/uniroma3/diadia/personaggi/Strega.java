package it.uniroma3.diadia.personaggi;

import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/*
 * se interagiamo con una strega questa ci 
 * trasferisce in una stanza tra quelle adiacenti.
 */

/*
 * Siccome è permalosa:
 * se non l’abbiamo ancora salutata, ci «trasferisce» nella 
 *  stanza adiacente che contiene meno attrezzi;
 *  altrimenti in quella che contiene più attrezzi
 */


public class Strega extends AbstractPersonaggio {

	private static final String MESSAGGIO_MAGICO = "Solo perché mi hai salutato,"
			+ "non ti mando in un scantinato!";
	private static final String MESSAGGIO_PERMALOSO = "Sei proprio una brutta persona,"
			+ "vai nella stanza con meno attrezzi!";
	
	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}
	
	@Override
	public String agisci(Partita partita) {
		String msg;
		List<Stanza> listaStanze = partita.getStanzaCorrente().getStanzeAdiacenti();
		Stanza minAttrezzi = listaStanze.get(0);
		Stanza maxAttrezzi = listaStanze.get(0);
		
		for (Stanza s: listaStanze) {
			if (s!=null) {
				if (s.getNumeroAttrezzi() > maxAttrezzi.getNumeroAttrezzi())
					maxAttrezzi = s;
				if (s.getNumeroAttrezzi() < minAttrezzi.getNumeroAttrezzi())
					minAttrezzi = s;
			}
		}
		
		if (this.haSalutato()) {
			partita.setStanzaCorrente(maxAttrezzi);
			msg = MESSAGGIO_MAGICO;
			
		} else {
			partita.setStanzaCorrente(minAttrezzi);
			msg = MESSAGGIO_PERMALOSO;
		}
		
		return msg;
	}
	
	/*
	 * una strega riceve un regalo, che trattiene scoppiando a ridere
	 */

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return "AHAHAHAHAHAHAHAHAHAHA";
	}

	
}
