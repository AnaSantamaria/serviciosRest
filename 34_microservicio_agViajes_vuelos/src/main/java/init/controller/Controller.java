package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import init.model.VuelosDto;
import init.service.VuelosService;

@CrossOrigin("*")
@RestController

public class Controller {
	@Autowired
	 VuelosService vuelosService;
	
	@GetMapping(value="vuelosDisponibles", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VuelosDto>> buscarVuelos (@RequestParam String destino,@RequestParam int plazas){
		  List<VuelosDto> vuelos = vuelosService.listaDeVuelos(destino, plazas);
		  
		  
		  if (!vuelos.isEmpty()) {
		        return new ResponseEntity<>(vuelos, HttpStatus.OK);
		    } 
		        
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	 	

    @PutMapping("actualizarPlazas/{idvuelo}")
    public ResponseEntity<Void> actualizarPlazas(@PathVariable int idvuelo, @RequestParam int reservas) {
        vuelosService.actualizarPlazas(idvuelo, reservas);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    
    @GetMapping(value="buscar/{idvuelo}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VuelosDto> buscarVuelo(@PathVariable int idvuelo) {
        VuelosDto vuelosDto = vuelosService.buscarVuelo(idvuelo);

        if (vuelosDto != null) {
        	
        	return new ResponseEntity<>(vuelosDto, HttpStatus.OK);
        } 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }

}

    

	
	
	
	
	
	
	


