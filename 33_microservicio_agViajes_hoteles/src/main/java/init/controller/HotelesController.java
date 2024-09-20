package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import init.Service.HotelesService;
import init.dto.HotelDto;




//Datos de hotel por identificador 
	// Lista de hoteles por localización 

@CrossOrigin("*")
@Controller
public class HotelesController {
	
	@Autowired
	HotelesService hotelesService;
	
	
	@GetMapping(value="buscar/{IdHotel}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HotelDto> buscarPorId (@PathVariable ("IdHotel") int idHotel){
		HotelDto hotel=hotelesService.buscarPorId(idHotel);
		
		if(hotel!=null) {
			
			return new ResponseEntity<>(hotel,HttpStatus.OK);
			
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
	}
	
	@GetMapping(value="buscarLocalizacion/{localizacion}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<HotelDto>> buscarPorLocalizacion(@PathVariable("localizacion") String localizacion){
		List<HotelDto> hoteles = hotelesService.buscarPorLocalizacion(localizacion);
		
		if(hoteles!=null && !hoteles.isEmpty()) {
			
			return new ResponseEntity<>(hoteles, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
		
	

}
