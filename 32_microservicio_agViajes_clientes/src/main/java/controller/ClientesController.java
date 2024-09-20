package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import entities.Cliente;
import service.ClientesService;

@CrossOrigin("*")
@Controller
public class ClientesController {
	
	@Autowired
	ClientesService clientesService;
	
	
	
	

	@PostMapping(value="registrar", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> registrar (@RequestBody Cliente cliente){
		
		if(clientesService.registrar(cliente)){
			
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		
	}
 
	@GetMapping(value="logar", produces=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Cliente> logar (@RequestParam("usuario") String usuario ,@RequestParam("contraseña") String contraseña){
		Cliente cliente = clientesService.loging(usuario, contraseña);
		
        if (cliente!=null) {
			
			return new ResponseEntity<>(cliente,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		
	
	}
		

	@GetMapping(value="buscar/{usuario}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> buscarPorUsuario (@PathVariable ("usuario") String usuario){
		Cliente cliente = clientesService.buscar(usuario);
		
		if (cliente!=null) {
			
			return new ResponseEntity<>(cliente,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
}

	


