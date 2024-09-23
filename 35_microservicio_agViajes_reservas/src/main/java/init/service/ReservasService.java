package init.service;

import java.util.List;

import init.model.ReservasDto;

public interface ReservasService {

	public interface ReservaService {
		List<ReservasDto> getReservas(String usuario);
		boolean altaReserva(ReservasDto reserva, int plazas);
	
}
}