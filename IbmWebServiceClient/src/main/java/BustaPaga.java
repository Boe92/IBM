import java.util.Date;

public class BustaPaga {

	private double importo;
	private Date data_emissione;
	private String codice_busta;

	public BustaPaga(){}
	
	
	public BustaPaga(double importo, Date data_emissione, String codice_busta) {
		this.importo = importo;
		this.data_emissione = data_emissione;
		this.codice_busta = codice_busta;
	}


	public double getImporto() {
		return importo;
	}
	public void setImporto(double importo) {
		this.importo = importo;
	}
	public Date getData_emissione() {
		return data_emissione;
	}
	public void setData_emissione(Date data_emissione) {
		this.data_emissione = data_emissione;
	}

	public String getCodice_busta() {
		return codice_busta;
	}

	public void setCodice_busta(String codice_busta) {
		this.codice_busta = codice_busta;
	}

}
