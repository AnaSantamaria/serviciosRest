package controller;

import java.util.List;

import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.Curso;
import service.FormacionService;
@Path("/formacion")
public class servicioFormacionController {
	
	FormacionService service = new FormacionService();
	
	@GET
	@Path("/buscar/{area}")
	@Produces(MediaType.APPLICATION_JSON)
	public List <Curso> cursoArea( @PathParam("area") String area) {
		
		return service.buscarPorArea(area);
	}
	@POST
	@Path("/alta")
	@Consumes(MediaType.APPLICATION_JSON)
	public void altaCurso(Curso curso) {
		
		service.altaFormacion(curso);
	}
}
