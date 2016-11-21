import java.util.List;

import javax.ws.rs.core.Response;

public class InvocazioneMain {

	public static void main(String[] args) {
		
		Invocazione invocazione = new Invocazione();
		
		Response risposta = invocazione.richiestaBustaPagaByCode().invoke();
		
		@SuppressWarnings("unchecked")
		List<BustaPaga> buste = (List<BustaPaga>) risposta.readEntity(BustaPaga.class);
		
		for(BustaPaga bp : buste) {
			System.out.println(bp.getImporto()+ " " + bp.getData_emissione()+ " " + bp.getCodice_busta());
		}
		
	}

}
