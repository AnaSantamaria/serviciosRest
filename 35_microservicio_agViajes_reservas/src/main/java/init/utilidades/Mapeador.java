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
					reserva.getHotel(),
					reserva.getVuelo(),
					reserva.getPrecio(),
					reserva.getUsuario());
					
					
			
}
			
			
			
public Reserva reservasDtoToEntity (ReservasDto reservaDto) {
	
			return new Reserva(
					reservaDto.getIdreserva(),
					reservaDto.getHotel(),
					reservaDto.getVuelo(),
					reservaDto.getPrecio(),
					reservaDto.getUsuario());
	
	

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

public Hotel hotelDtoToEntity (HotelDto hotelDto) {
	
			return new Hotel(
					hotelDto.getIdHotel(),
					hotelDto.getNombre(),
					hotelDto.getCategoria(),
					hotelDto.getPrecio(),
					hotelDto.isDisponible(),
					hotelDto.getLocalizacion());
			
			
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
