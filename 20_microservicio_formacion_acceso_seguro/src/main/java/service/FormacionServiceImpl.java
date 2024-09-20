package service;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import model.Curso;
@Service
public class FormacionServiceImpl implements FormacionService {
	
	@Value("${usuario}")// la anotacion @value sirve para inyectar variables declaradas en application properties
	String user;
	
	@Value("${pwd}")
	String pass;
	
	@Value("${admin.user}")
	String userAdmin;
	
	@Value("${admin.pass}")
	String passAdmin;
	
	String url="http://localhost:8000/cursos/";
	
	RestClient restClient;
	
	
	public FormacionServiceImpl(RestClient restClient) {
		super();
		this.restClient = restClient;
	}

	@Override
	public List<Curso> buscarPorArea(String area) {//.get().uri(url+"recuperartodos").body(Curso[].class) es la programacion de la llamada. el resto del metodo es para tratar la info que me llega
		
	return	Arrays.stream(restClient
		
		.get()
		.uri(url+"recuperartodos")// recupero todos y luego filtro
		//
		.header("Authorization","Basic"+getBase64(user, pass))// instruccion que se hace antes de la llamada (.retrieve) para hacer la cabecera para meter mis credenciales
		//
		.retrieve()
		.body(Curso[].class)//esto me devuelve un Array de objetos Curso /.class es la clase o tipo de objeto que va a recoger el body
		)//Stream<Formacion>
		.filter(f->f.getArea().equals(area))
		.toList();
		
	}

	@Override
	public void altaFormacion(Curso curso) { //como en este metodo no necesito hacer narda con la info, solo se compone pe la llamada o solicitud
		restClient
		.post()
		.uri(url+"alta")
		.contentType(MediaType.APPLICATION_JSON)
		.body(curso)// es lo que quiero meter en el body
		.retrieve()// es para realizar la llamarda
		.toBodilessEntity();//para que muestre el error si lo hubiera??
	}
	
	private String getBase64(String us, String pwd) {// metodo de uso interno
		String cad=us+":"+pwd;
		return Base64.getEncoder().encodeToString(cad.getBytes());
	} 

}
