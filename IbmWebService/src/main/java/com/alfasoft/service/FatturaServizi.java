package com.alfasoft.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import com.alfasoft.dao.FatturaDao;
import com.alfasoft.entita.Fattura;

public class FatturaServizi {
	FatturaDao fd = new FatturaDao();
	
	public List<Fattura> leggiTutteFatture() {
		List<Fattura> fatture = fd._selectAll();
		
		return fatture;
	}
	
	public void inserisciFattura(Fattura f, String path) {
		boolean res = fd._insert(f);
		
		if(res) {
			//creaPdf(f, path);
			creaPdfTabella(f, path);
		}
	}
	
	public void creaPdf(Fattura f, String path) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		
		int anno = cal.get(Calendar.YEAR);
		int mese = cal.get(Calendar.MONTH)+1;
		int giorno = cal.get(Calendar.DAY_OF_MONTH);
		
		String nomeFile = "ElencoFatture_"+anno+"-"+mese+"-"+giorno+".pdf";
		String percorso  = "C:\\Users\\alexb\\Documents\\pdfJersey\\";
		String fileFinale = percorso + nomeFile;

		try {
	           Map<String, Object> parameters = new HashMap<String, Object>();
	                   
        	   parameters.put("importo", f.getImporto());
        	   parameters.put("codice_fattura", f.getCodice_fattura());
        	   parameters.put("data_emissione", f.getData_emissione());
        	   
        	   JasperPrint jasperPrint = JasperFillManager.fillReport(path, parameters, new JREmptyDataSource());
	
	           OutputStream outputStream = new FileOutputStream(new File(fileFinale));

	           JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
	
	           System.out.println("File e' stato creato");
	       } catch (JRException ex) {
	           ex.printStackTrace();
	       } catch (FileNotFoundException ex) {
	           ex.printStackTrace();
	       }
	}
	
	public void creaPdfTabella(Fattura f, String path) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		
		int anno = cal.get(Calendar.YEAR);
		int mese = cal.get(Calendar.MONTH)+1;
		int giorno = cal.get(Calendar.DAY_OF_MONTH);
		
		String nomeFile = "ElencoFatture_"+anno+"-"+mese+"-"+giorno+".pdf";
		String percorso  = "C:\\Users\\corso\\Desktop\\pdfJersey\\";
		String fileFinale = percorso + nomeFile;

		try {
				List<Fattura> fatture = fd._selectAll();

				// Converto la  lista to JRBeanCollectionDataSource 
				JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(fatture, false);

				//  una mappa per mandare i parametri a Jasper 
	           	Map<String, Object> parameters = new HashMap<String, Object>();
	         
	           	parameters.put("FattureDataSource", itemsJRBean);
				parameters.put("importo", f.getImporto());
				parameters.put("codice_fattura", f.getCodice_fattura());
				parameters.put("data_emissione", f.getData_emissione());
				   
				JasperPrint jasperPrint = JasperFillManager.fillReport(path, parameters, new JREmptyDataSource());
				
				OutputStream outputStream = new FileOutputStream(new File(fileFinale));
				
				JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
				
				System.out.println("File e' stato creato");
	       } catch (JRException ex) {
	           ex.printStackTrace();
	       } catch (FileNotFoundException ex) {
	           ex.printStackTrace();
	       }
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
