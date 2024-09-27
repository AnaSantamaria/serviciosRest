package service;



import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

import jakarta.annotation.PostConstruct;
import model.Curso;
import model.TokenResponse;
@Service
public class FormacionServiceImpl implements FormacionService {
	
	@Value("${app.urlAuth}")
	String urlAuth;
	@Value("${app.username}")
	String username;
	@Value("${app.password}")
	String password;
	@Value("${app.client_id}")
	String clientId;
	@Value("${app.grant_type}")
	String grantType;
	
	String url="http://localhost:8000/cursos/";
	RestClient restClient;
	String token; 
	
	
	public FormacionServiceImpl(RestClient restClient) {
		super();
		this.restClient = restClient;
	}
	
	@PostConstruct
	public void init() {// esto lo hago en postContructor ya que en mi constructor inicial aún no estan las propieades que he declarado al inicio
		token= getToken();
		
	}
	
	  private String getToken() {
		  //aqui se conecta con keycloak y se recoge el token que nos viene en formato json 
		  MultiValueMap<String,String> params=new LinkedMultiValueMap<>();
			params.add("client_id", clientId);
			params.add("username", username);
			params.add("password", password);
			params.add("grant_type", grantType);
			
			return restClient.post()
			.uri(urlAuth)
			.contentType(MediaType.APPLICATION_FORM_URLENCODED)
			.body(params)
			.retrieve()
			.body(TokenResponse.class) //TokenResponse
			.getAcces_token(); 
		  
		  
	  }
	@Override
	public List<Curso> buscarPorArea(String area) {//.get().uri(url+"recuperartodos").body(Curso[].class) es la programacion de la llamada. el resto del metodo es para tratar la info que me llega
		
	return	Arrays.stream(restClient
		
		.get()
		.uri(url+"recuperartodos")// recupero todos y luego filtro
		//
		.header("Authorization","Basic"+getBase64(username, password))// instruccion que se hace antes de la llamada (.retrieve) para hacer la cabecera para meter mis credenciales
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
