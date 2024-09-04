package controller;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/pruebas")
public class SaludoController {
	@GET //El metodo se ejecutará con peticiones GET
	@Path("/saludar")
	@Produces(MediaType.TEXT_PLAIN)
	public String getSaludo() {
		
		return "Bienvenido humano";
	}
	
	//Primero el codigo
	//depués anotaciones: @Path, @endpoints , otra @Path para indicar cual es el metodo que quiero ejecutar en funcion de la peticion, @Produces para indicar el tipo de texto
	// 3ªCrear clase config en paquete controller que extends de Application

	/*la direccion para que se ejecute este programa sería:
	 *  Http://localhost:8080/01_ejemplo_rest/servicio(**esta anotacion esta en la clase config del controller**)/pruebas/saludar. 
	 *  Si nos fijamos sigue una a una las anotaciones @Path*/
	
	
	@GET //El metodo se ejecutará con peticiones GET
	@Path("/saludar/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getsaludoPersonal(@jakarta.ws.rs.PathParam("name") String nombre) {
		return "Bienvenido querid@" +nombre;
		
		
	}
	
	/*Pra mandar variables se hace a continuacion del Path de la siguente manera: {variable} y a la variable del método hay que añadir tb una anotación:
	 *  @PathParam("variable") delante del parametro que le pasamos al método*/
	
	@GET //El metodo se ejecutará con peticiones GET
	@Path("/info")
	@Produces(MediaType.TEXT_PLAIN)
	public String getInfo(@QueryParam("name") String nombre, @QueryParam("age") int edad) {
		return "Te llamas " + nombre +" y tienes " + edad +"años";
		
		
	}
}
 


