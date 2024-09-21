package init.service;

import java.util.List;

import init.entities.Vuelo;
import init.model.VuelosDto;

public interface VuelosService {
	
	//Lista de vuelos a partir de un destino y número de plazas
	
	
	List<VuelosDto> listaDeVuelos (String destino, int plazas);
	
	
	
	
	//Actualización de plazas a partir de identificador de vuelo y plazas reservadas (securizado de maneara que solo usuarios de un determinado rol puedan utilizarlo)
	
	
	
	
	void actualizarPlazas (int idvuelo, int reservas);
	
	
	
	
	
	//Datos de Vuelo por identificador

	VuelosDto buscarVuelo (int idvuelo);

}
