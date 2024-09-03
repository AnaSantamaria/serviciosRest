package controller;

import java.util.List;

import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.Curso;
import service.CursosService;



@Path("/cursos")
public class CursosController {
		
	CursosService cursosService=new CursosService();
		
	@POST
	@Path("/alta")
	@Produces(MediaType.APPLICATION_JSON)
	public void alta(Curso curso) {
		
		cursosService.alta(curso);
	}
	
	@DELETE
	@Path("/eliminar/{nombre}")
	//@Consumnes o @Produces no se pone ya que ni se recibe ni a generar nada en el cuerpo
	public void eliminar(@PathParam("nombre") String nombre) {
		cursosService.eliminar(nombre);
		
		
	}
	@PUT
	@Path("/actualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizar ( Curso curso ) {
		
		cursosService.modificarDatos(curso);
		
		
	}
	@GET
	@Path("/buscar/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public Curso buscarPorNombre(String nombre) {
		
		return cursosService.buscarCurso(nombre);
		
	}
	@PUT
	@Path("/recuperar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Curso> recuperarTodos(){
		return cursosService.devuelveCursos();
		
			
	}
}
