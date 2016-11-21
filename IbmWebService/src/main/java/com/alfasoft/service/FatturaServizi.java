package com.alfasoft.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
	
	public List<Fattura> cercaFatture(String anno) {

		List<Fattura> fatture = fd._selectAll();
		List<Fattura> out = new ArrayList<Fattura>();
		for (Fattura f : fatture) {
			Date date = f.getData_emissione();
			if (date != null) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(date); 
				int year = cal.get(Calendar.YEAR);
				if (Integer.parseInt(anno) == year) {
					out.add(f);
				}
			}
		}
		return out;
	}
	
	public List<Fattura> cercaFatture(String anno, String mese) {

		List<Fattura> fatture = fd._selectAll();
		List<Fattura> out = new ArrayList<Fattura>();
		for (Fattura f : fatture) {
			Date date = f.getData_emissione();
			if (date != null) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH);
				if (Integer.parseInt(anno) == year && Integer.parseInt(mese) == ++month) {
					out.add(f);
				}
			}
		}
		return out;
	}
}
