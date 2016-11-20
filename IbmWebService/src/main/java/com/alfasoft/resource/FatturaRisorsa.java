package com.alfasoft.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alfasoft.entita.Fattura;
import com.alfasoft.service.FatturaServizi;

@Path("/risorsa")
@Produces(MediaType.APPLICATION_JSON)
public class FatturaRisorsa {
	
	FatturaServizi fs = new FatturaServizi();
	
	/********* FUNZIONANTI *********/
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void aggiungiFattura(Fattura f) {
		fs.inserisciFattura(f);
	}
	
	@Path("/{OggettoFattura}") // si riferisce al PathParam, ovvero al parametro che stiamo passando e non come indirizzo
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Fattura getFatturaCode(@PathParam("OggettoFattura") String codice) {
		return fs.leggiFatturaCodice(codice);
	}
	
	@Path("/listaFatture")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Fattura> getTutteFatture() {
		return new ArrayList<Fattura>(fs.leggiTutteFatture());
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void aggiornaFattura(Fattura f) {
		fs.modificaFattura(f);
	}
	
	
	
	
	/********* IN FASE DI SVILUPPO *********/
	
	@Path("/{Anno}") // si riferisce al PathParam, ovvero al parametro che stiamo passando e non come indirizzo
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Fattura getFatturaAnno(@PathParam("Anno") String anno) {
		return null;
	}
	
	@Path("/{Anno}/{Mese}") // si riferisce al PathParam, ovvero al parametro che stiamo passando e non come indirizzo
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Fattura getFatturaAnnoMese(@PathParam("Anno") String anno, @PathParam("Mese") String mese) {
		return null;
	}
	
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public void eliminaFattura(int id) {
		fs.eliminaFattura(id);
	}
}