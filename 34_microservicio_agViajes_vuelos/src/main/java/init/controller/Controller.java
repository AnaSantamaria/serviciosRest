package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping(value="vuelos", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VuelosDto>> buscarVuelos (@RequestParam String destino,@RequestParam int plazas){
		  List<VuelosDto> vuelos = vuelosService.listaDeVuelos(destino, plazas);
		    return ResponseEntity.ok(vuelos);
		
	}
	
	//Lista de vuelos a partir de un destino y número de plazas
	
	
	/*Chat gpt: revisar
	 * 
	 * 
	 */ // Endpoint para actualizar plazas
    @PutMapping("/actualizarPlazas/{idvuelo}")
    public ResponseEntity<Void> actualizarPlazas(@PathVariable int idvuelo, @RequestParam int reservas) {
        vuelosService.actualizarPlazas(idvuelo, reservas);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para buscar vuelo por ID
    @GetMapping("/{idvuelo}")
    public ResponseEntity<VuelosDto> buscarVuelo(@PathVariable int idvuelo) {
        VuelosDto vuelosDto = vuelosService.buscarVuelo(idvuelo);
        return vuelosDto != null ? ResponseEntity.ok(vuelosDto) : ResponseEntity.notFound().build();
    }
}
	
	//Actualización de plazas a partir de identificador de vuelo y plazas reservadas (securizado de maneara que solo usuarios de un determinado rol puedan utilizarlo)
	//Datos de Vuelo por identificador

	
	
	
	
	
	
	


