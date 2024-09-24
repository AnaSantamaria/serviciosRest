package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import init.model.ReservasDto;
import init.service.ReservasService;

// Alta de la misma con los datos de reserva (securizado para que solo usuarios de un 
//determinado rol puedan utilizarlo). //Lista de reservas por cliente


@CrossOrigin("*")
@RestController

public class ReservasController {
	
	@Autowired
	ReservasService reservasService;
	
	@PostMapping(value = "alta/{plazas}", consumes=MediaType.APPLICATION_JSON_VALUE) 
public ResponseEntity<String> altaReserva (@RequestBody ReservasDto reservaDto, @RequestParam int plazas){
	
	boolean nuevoAlta = reservasService.altaReserva(reservaDto, plazas);
	
	if (nuevoAlta != false) {
		
		 return ResponseEntity.ok("reserva creada correctamente");
		
		
	}
	
	return ResponseEntity.badRequest().body("Error al crear la reserva.");
	
}
	@GetMapping (value= "reservasPorCliente/{usuario}")
	public ResponseEntity<List<ReservasDto>> reservasPorCliente (@PathVariable String usuario){
		
		List<ReservasDto> listaReservas =reservasService.listaDeReservas(usuario);
		
		if(listaReservas !=  null) {
			
			return new ResponseEntity<>(listaReservas, HttpStatus.OK);
		}
		
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
