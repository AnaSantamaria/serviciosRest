package init.utilidades;


import org.springframework.stereotype.Component;

import init.dto.HotelDto;
import init.entities.Hotel;

@Component
public class Mapeador {

	public HotelDto hotelEntityToDto (Hotel hotel) {
		
		return new HotelDto(hotel.getIdHotel(),
								hotel.getNombre(),
								hotel.getCategoria(),
								hotel.getPrecio(),
								hotel.isDisponible(),
								hotel.getLocalizacion());
		
		
	}
}
