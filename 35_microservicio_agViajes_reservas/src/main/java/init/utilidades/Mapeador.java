package init.utilidades;

import init.entities.Hotel;
import init.entities.Reserva;
import init.entities.Vuelo;
import init.model.HotelDto;
import init.model.ReservasDto;
import init.model.VuelosDto;

public class Mapeador {
	
	
	
public ReservasDto resrevaEntityToDto (Reserva reserva) {
	
			return new ReservasDto(
					reserva.getIdreserva(),
					reserva.getNombre(),
					reserva.getDni(),
					reserva.getHotel(),
					reserva.getVuelo(),
					reserva.getPrecio());
			
}
			
			
			
public Reserva reservasDtoToEntyti (ReservasDto reservaDto) {
	
			return new Reserva(
					reservaDto.getIdreserva(),
					reservaDto.getNombre(),
					reservaDto.getDni(),
					reservaDto.getHotel(),
					reservaDto.getVuelo(),
					reservaDto.getPrecio());
	
	

}
	
	
	
public HotelDto hotelEntityToDto (Hotel hotel) {
		
				return new HotelDto(
								hotel.getIdHotel(),
								hotel.getNombre(),
								hotel.getCategoria(),
								hotel.getPrecio(),
								hotel.isDisponible(),
								hotel.getLocalizacion());
		
		
	}

public VuelosDto VuelosEntityToDto (Vuelo vuelo) {
	
			return new VuelosDto(
							vuelo.getIdvuelo(),
							vuelo.getCompany(),
							vuelo.getFecha(),
							vuelo.getPrecio(),
							vuelo.getPlazas(),
							vuelo.getDestino());
							
}

public Vuelo vuelosDtoToEntity (VuelosDto vuelosDto) {
	
			return new Vuelo(
							vuelosDto.getIdvuelo(),
							vuelosDto.getCompany(),
							vuelosDto.getFecha(),
							vuelosDto.getPrecio(),
							vuelosDto.getPlazas(),
							vuelosDto.getDestino());
			
}

}
