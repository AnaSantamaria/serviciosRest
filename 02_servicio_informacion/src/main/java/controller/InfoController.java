package controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.Ficha;

//Hay que devolver al cliente una ficha de informacion de producto en formato JSON

@Path("/informacion")
public class InfoController {
	@GET	
	@Path("/ficha")//es la direccion concreta que le doy
	@Produces(MediaType.APPLICATION_JSON)// asi convierto texto en Json que es lo que quiero devolver
	public Ficha fichaProducto() {
		return new Ficha("pc",800,"informatica");
		
		
	}

}//anotaciones GET, Path y Produces
