package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezzi;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
//	private Map<String, Attrezzo> attrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<Attrezzo>();
//		this.attrezzi = new HashMap<String, Attrezzo>();
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo == null)
			return false;
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.attrezzi.add(attrezzo);
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		for (Attrezzo a : this.attrezzi)
			if (a != null && a.getNome().equals(nomeAttrezzo))
				return a;
		return null;
	}

	public int getPeso() {
		int peso = 0;
		for (Attrezzo a : this.attrezzi)
			peso += a.getPeso();
		return peso;
	}

	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.contains(this.getAttrezzo(nomeAttrezzo));
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		if (nomeAttrezzo != null && this.hasAttrezzo(nomeAttrezzo)) {
			Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
			while (iteratore.hasNext()) {
				a = iteratore.next();
				if (a.getNome().equals(nomeAttrezzo))
					iteratore.remove();
				return a;
			}
		}
		return null;
	}
	/*
	 * Restituisce la lista degli attrezzi nella borsa ordinato
	 * per peso e a parità del peso, per nome
	 */
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		ComparatoreAttrezzi comp = new ComparatoreAttrezzi();
		Collections.sort(attrezzi, comp);
		return this.attrezzi;
	}
	
	/*
	 * Restituisce l'insieme degli attrezzi nella borsa ordinato per nome
	 */
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		SortedSet<Attrezzo> res = new TreeSet<Attrezzo>();
		res.addAll(this.attrezzi);
		return res;
	}
	
	/*
	 * restituisce una mappa che associa un intero con l'insieme degli attrezzi
	 * tale peso: tutti gli attrezzi dell'insieme che figura come valore hanno
	 * lo stesso peso pari all'intero che figura come chiave
	 */
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Map<Integer, Set<Attrezzo>> mappa = new HashMap<Integer, Set<Attrezzo>>();
		for (Attrezzo attrezzo: this.attrezzi) {
			if (!mappa.containsKey(attrezzo.getPeso())) {
				mappa.put(attrezzo.getPeso(), new HashSet<Attrezzo>());
			mappa.get(attrezzo.getPeso()).add(attrezzo);
			}
		}
		return mappa;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		SortedSet<Attrezzo> risultato = new TreeSet<Attrezzo>(new ComparatoreAttrezzi());
		risultato.addAll(this.attrezzi);
		return risultato;
	}
	

	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			for (Attrezzo a : this.attrezzi)
				s.append(a.toString() + " ");
		} else
			s.append("Borsa vuota");
		return s.toString();
	}
}