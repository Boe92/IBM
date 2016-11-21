package com.alfasoft.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alfasoft.dao.FatturaDao;
import com.alfasoft.entita.Fattura;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ProvaMain {

	public static void main(String[] args) {
		FatturaDao fd = new FatturaDao();
		Date d = new Date();
		Fattura f = new Fattura();
		
		f.setData_emissione(d);
		f.setImporto(1234);
		f.setCodice_fattura("ABC");
		fd._insert(f);
		

//		FatturaDao fDao=new FatturaDao();
//		
//		Double d;
//		
//		String nomeFile="ElencoFatture.pdf";
//		
//		String percorso  = "C:\\Users\\admin\\Documents\\A0\\";
//		 
//		String fileFinale=percorso+nomeFile;
//
//		try {
//             
//
//           //la mia lista che mantiene i dati
//           List<Fattura> fatture = fDao._selectAll();
//     
//
//           // Converto la  lista to JRBeanCollectionDataSource 
//           JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(fatture,false);
//
//           //  una mappa per mandare i parametri a Jasper 
//           Map<String, Object> parameters = new HashMap<String, Object>();
//         
//           parameters.put("FattureDataSource", itemsJRBean);
//           parameters.put("importo", 2.5);
//
//           //  file compilato di jasper (.jasper) di Jasper Report per creare  PDF 
//           JasperPrint jasperPrint = JasperFillManager.fillReport("fattura.jasper", parameters, new JREmptyDataSource());
//
//           //outputStream per creare PDF 
//           OutputStream outputStream = new FileOutputStream(new File(fileFinale));
//          
//           
//           // scrivo in un  file PDF  
//         
//           JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
//
//           System.out.println("File e' stato creato");
// 
//       } catch (JRException ex) {
//           ex.printStackTrace();
//       } catch (FileNotFoundException ex) {
//           ex.printStackTrace();
//       }
		
	}
}