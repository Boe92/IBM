import java.util.Date;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

public class Invocazione {

	private Client cliente= ClientBuilder.newClient();
	private WebTarget baseTarget = 	cliente.target("http://localhost:5050/IbmWebService/webapi");
	private WebTarget dipTarget = baseTarget.path("/risorsa");
	Fattura fattura;
	
	public Invocazione() {
		
	}
	
	public Invocation richiestaBustaPagaByCode(){
		fattura = new Fattura(12,1234, "ZXC", new Date());
		return dipTarget.request().buildPost(Entity.json(fattura));
	}
	
//	public List<BustaPaga> getAllBuste() {
//		return dipTarget.request().get().readEntity(new GenericType<List<BustaPaga>>(){});
//	}
	
}