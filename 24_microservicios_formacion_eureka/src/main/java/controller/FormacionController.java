package controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Curso;
import service.FormacionService;
@CrossOrigin("*")
@RestController
public class FormacionController {
	
	FormacionService formacionService;

	public FormacionController(FormacionService formacionService) {
		super();
		this.formacionService = formacionService;
	}
	
	@GetMapping(value="consulta/{area}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> consultarPorArea(@PathVariable("area") String area){
		return formacionService.buscarPorArea(area);
	}
	
	@PostMapping(value ="alta",consumes= MediaType.APPLICATION_JSON_VALUE)
	public void altaFormacion(@RequestBody Curso curso) {
		
		formacionService.altaFormacion(curso);
	}

}
