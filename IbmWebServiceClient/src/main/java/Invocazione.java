import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

public class Invocazione {

	private Client cliente= ClientBuilder.newClient();
	private WebTarget baseTarget = 	cliente.target("http://localhost:5050/IbmWebService/webapi");
	private WebTarget dipTarget= baseTarget.path("/risorsa");
	
	public Invocazione() {
		//baseTarget= cliente.target("http://localhost:5050/IbmWebService/webapi");
		//dipTarget= baseTarget.path("/risorsa");
	}
	
	public Invocation richiestaFatturaByCode(String code){
		
		return dipTarget.path(code).request().buildGet();
	}
	
	
}