import javax.ws.rs.core.Response;

public class InvocazioneMain {

	public static void main(String[] args) {
		
		Invocazione invocazione = new Invocazione();
		
		Response risposta = invocazione.richiestaFatturaByCode("ABC")
					.invoke();
		
		Fattura f = risposta.readEntity(Fattura.class);
		
		System.out.println(f.getImporto()+ " " + f.getData_emissione()+ " " + f.getCodice_fattura());

	}

}
