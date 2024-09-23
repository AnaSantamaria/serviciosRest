package init.service;

import java.util.List;

import init.entities.Reserva;
import init.model.HotelDto;
import init.model.ReservasDto;

public interface ReservasService {
	
	//Alta de la misma con los datos de reserva 
	
	boolean altaReserva(HotelDto hotel, int plazas);
			
			// Lista de reservas por cliente

	List<ReservasDto> listaDeReservas (String usuario);
	
	
	
	
}
