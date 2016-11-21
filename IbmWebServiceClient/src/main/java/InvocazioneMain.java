import java.util.List;

public class InvocazioneMain {

	public static void main(String[] args) {
		
		Invocazione invocazione = new Invocazione();
		
		//Response risposta = invocazione.richiestaBustaPagaByCode().invoke();
		
		List<BustaPaga> buste = invocazione.getAllBuste();
		
		for(BustaPaga bp : buste) {
			System.out.println(bp.getImporto()+ " " + bp.getData_emissione()+ " " + bp.getCodice_busta());
		}
	}
}
