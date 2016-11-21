import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

public class Invocazione {

	private Client cliente= ClientBuilder.newClient();
	private WebTarget baseTarget = 	cliente.target("http://10.0.1.149:8086/AziendaWebService/webapi");
	private WebTarget dipTarget= baseTarget.path("/listaBuste");
	
	public Invocazione() {
		
	}
	
	public Invocation richiestaBustaPagaByCode(){
		
		return dipTarget.request().buildGet();
	}
	
	public List<BustaPaga> getAllBuste() {
		return dipTarget.request().get().readEntity(new GenericType<List<BustaPaga>>(){});
	}
	
}