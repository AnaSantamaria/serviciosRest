package controller;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import model.Resultado;
import sevice.BuscadorService;

@Path("/buscador")
public class BuscadorController {

	BuscadorService buscadorService = new BuscadorService();

	@GET
	@Path("/buscar/{tematica}")
	@Produces(MediaType.APPLICATION_JSON) // asi convierto texto en Json que es lo que quiero DEVOLVER

	public List<Resultado> buscar(@PathParam("tematica") String tematica) {

		return buscadorService.buscar(tematica);

	}

	@POST
	@Path("/alta")
	@Consumes(MediaType.APPLICATION_JSON) // asi convierto texto en Json que es como voy a RECIBIR la llamada y si se la
											// devolveré
	public void alta(Resultado resultado) {
		buscadorService.alta(resultado);

	}

	@DELETE
	@Path("/eliminar")
	@Produces(MediaType.APPLICATION_JSON)

	public List<Resultado> eliminar(@QueryParam("url") String url) { // se pone anotacion @QueryParam ya que las url
																		// vancon barras y si pones @PathParam puede ser
																		// confuso

		return buscadorService.eliminar(url);

	}
}
