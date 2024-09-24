package init.utilidades;

import org.springframework.stereotype.Component;

import init.entities.Hotel;
import init.entities.Reserva;
import init.entities.Vuelo;
import init.model.HotelDto;
import init.model.ReservasDto;
import init.model.VuelosDto;

@Component
public class Mapeador {
	
	
	
	public ReservasDto reservaEntityToDto(Reserva reserva) {
        return new ReservasDto(
                reserva.getIdreserva(),
                hotelEntityToDto(reserva.getHotel()),  // Convierte el hotel a DTO
                vuelosEntityToDto(reserva.getVuelo()), // Convierte el vuelo a DTO
                reserva.getPrecio(),
                reserva.getUsuario()
        );
    }

    // Método para mapear ReservasDto a Reserva Entity
    public Reserva reservasDtoToEntity(ReservasDto reservaDto) {
        return new Reserva(
                reservaDto.getIdreserva(),
                hotelDtoToEntity(reservaDto.getHotel()),  // Convierte el hotel DTO a entidad
                vuelosDtoToEntity(reservaDto.getVuelo()), // Convierte el vuelo DTO a entidad
                reservaDto.getPrecio(),
                reservaDto.getUsuario()
        );
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
public VuelosDto vuelosEntityToDto (Vuelo vuelo) {
	
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
