package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class ComparatoreAttrezzi implements Comparator<Attrezzo> {

	@Override
	public int compare(Attrezzo a1, Attrezzo a2) {
		int res = 0;
		res = (a1.getPeso()) - (a2.getPeso());
		if ( res == 0)
			res = a1.getNome().compareTo(a2.getNome());
		return res;
	}

}
