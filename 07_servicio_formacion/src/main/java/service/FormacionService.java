package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import model.Curso;

public class FormacionService {
	
	String url="http://localhost:8080/04_servicio_crud_cursos/cursos";

			WebTarget wt=ClientBuilder
					.newClient()// Client
					.target(url);//WebTarget
	
	
			public List<Curso> buscarPorArea(String area){
				Curso[] todos=wt
				.path("/recuperartodos")
				.request(MediaType.APPLICATION_JSON)
				.get(Curso[].class);
				
				return Arrays.stream(todos)
				.filter(f->f.getArea().equals(area))
				.toList();
			}

			public void altaFormacion(Curso curso) {
				wt
				.path(url)
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(curso, MediaType.APPLICATION_JSON));// los parametros que paso son el objeto con el que estoy trabajando y el formato en el que lo quiero enviar
	
	
}
			
	}


