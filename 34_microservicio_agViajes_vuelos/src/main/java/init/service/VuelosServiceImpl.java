package init.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.dao.VuelosDao;
import init.entities.Vuelo;
import init.model.VuelosDto;
import init.utilidades.Mapeador;

@Service
public class VuelosServiceImpl implements VuelosService {
	
	@Autowired
	VuelosDao vuelosDao;
	@Autowired
	Mapeador mapeador;
	
	
	@Override
	public void actualizarPlazas(int idvuelo, int reservas) {
		   
		vuelosDao.actualizarPlazas(idvuelo, reservas);

	}

	@Override
	public VuelosDto buscarVuelo(int idvuelo) {
		
		Vuelo vuelo = vuelosDao.findById(idvuelo).orElse(null);
		
		if(vuelo !=null) {
			 
			return mapeador.VuelosEntityToDto(vuelo);
		}
		
		return null;
	}

	@Override
	public List<VuelosDto> listaDeVuelos(String destino, int plazas) {
		
		List<Vuelo> vuelos = vuelosDao.findByDestinoYPlazas(destino, plazas);
	    List<VuelosDto> vuelosDtos = new ArrayList<>();

	    if (vuelos != null && !vuelos.isEmpty()) {
	        for (Vuelo vuelo : vuelos) {
	            VuelosDto dto = mapeador.VuelosEntityToDto(vuelo);
	            if (dto != null) {
	                vuelosDtos.add(dto); 
	            }
	        }
	    }
	    
	    return vuelosDtos;
	}
}


