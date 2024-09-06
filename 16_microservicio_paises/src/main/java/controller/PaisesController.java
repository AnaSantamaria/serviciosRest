package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Pais;
import service.PaisesService;
@CrossOrigin("*")
@RestController
public class PaisesController {
	
	@Autowired
	PaisesService paisesService;
	
	/*@GetMapping(value= "continentes",produces=MediaType.APPLICATION_JSON_VALUE) 
	public List<String> continentes(){
		
		return paisesService.continentes();
	}*/
	  
	//Para devolver un error concreto que yo quiera al cliente si se produce una excepcion, tengo que cambiar el tipo de devolucion del método, por eso rehago el metodo
	@GetMapping(value= "continentes",produces=MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity< List<String>> continentes(){
		try {
			List<String> continentes = paisesService.continentes();
			return new ResponseEntity<>(continentes,HttpStatus.OK);
		}catch(RuntimeException ex){
			
			return new ResponseEntity<>(null,HttpStatus.SERVICE_UNAVAILABLE);
			
			
		}
	}
	  
	/*@GetMapping(value="pais/{continente}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pais> pais (@PathVariable String continente){
		return paisesService.buscarPaisesPorContinente(continente);
		
	}*/
	
	
	
	@GetMapping(value="paises/{continente}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pais>> paises(@PathVariable("continente") String continente){
		try {//si pido una lista y todo va bien, devuelvo unStatus ok, si no, lanzo una excepcion de servicio no disponible (503)
			List<Pais> paises= paisesService.buscarPaisesPorContinente(continente);
			return new ResponseEntity<>(paises,HttpStatus.OK);
		}catch(RuntimeException ex) {
			return new ResponseEntity<>(null,HttpStatus.SERVICE_UNAVAILABLE);
		}
		
	}
}
