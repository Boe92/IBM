package com.alfasoft.main;

import java.util.Date;

import com.alfasoft.dao.FatturaDao;
import com.alfasoft.entita.Fattura;

public class ProvaMain {

	public static void main(String[] args) {
		FatturaDao fd = new FatturaDao();
		Date d = new Date();
		Fattura f = new Fattura();
		
		f.setData_emissione(d);
		f.setImporto(1234);
		f.setCodice_fattura("ABC");
		fd._insert(f);
	}
}