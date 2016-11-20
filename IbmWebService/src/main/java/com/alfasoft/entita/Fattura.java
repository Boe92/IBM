package com.alfasoft.entita;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Fattura {
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private double importo;
	private String codice_fattura;
	private Date data_emissione;
	
	public Fattura() {}
	

	public Fattura(int id, double importo, String codice_fattura, Date data_emissione) {
		this.id = id;
		this.importo = importo;
		this.codice_fattura = codice_fattura;
		this.data_emissione = data_emissione;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getImporto() {
		return importo;
	}
	public void setImporto(double importo) {
		this.importo = importo;
	}
	public String getCodice_fattura() {
		return codice_fattura;
	}
	public void setCodice_fattura(String codice_fattura) {
		this.codice_fattura = codice_fattura;
	}
	public Date getData_emissione() {
		return data_emissione;
	}
	public void setData_emissione(Date data_emissione) {
		this.data_emissione = data_emissione;
	}
	
	
}
