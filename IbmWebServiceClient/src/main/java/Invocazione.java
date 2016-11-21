import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

public class Invocazione {

	private Client cliente= ClientBuilder.newClient();
	private WebTarget baseTarget = 	cliente.target("http://localhost:8085/AziendaWebService/webapi");
	private WebTarget dipTarget= baseTarget.path("/listaBuste");
	
	public Invocazione() {
		
	}
	
	public Invocation richiestaBustaPagaByCode(){
		
		return dipTarget.request().buildGet();
	}
	
	
}