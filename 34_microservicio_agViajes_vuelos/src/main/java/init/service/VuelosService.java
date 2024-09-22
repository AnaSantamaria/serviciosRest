package init.service;

import java.util.List;



import init.model.VuelosDto;

public interface VuelosService {
	
	
	
	List<VuelosDto> listaDeVuelos (String destino, int plazas);
	
	void actualizarPlazas (int idvuelo, int reservas);
	
	VuelosDto buscarVuelo (int idvuelo);

}
