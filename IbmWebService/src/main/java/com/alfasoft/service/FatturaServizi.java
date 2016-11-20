package com.alfasoft.service;

import java.util.List;

import com.alfasoft.dao.FatturaDao;
import com.alfasoft.entita.Fattura;

public class FatturaServizi {
	FatturaDao fd = new FatturaDao();
	
	public List<Fattura> leggiTutteFatture() {
		List<Fattura> fatture = fd._selectAll();
		
		return fatture;
	}
	
	public void inserisciFattura(Fattura f) {
		fd._insert(f);
	}
	
	public void modificaFattura(Fattura f) {
		fd._update(f);
	}
	
	public void eliminaFattura(int id) {
		fd._delete(id);
	}
	
	public Fattura leggiFatturaCodice(String codice) {
		Fattura f = fd._select(codice);
		
		return f;
	}
}
