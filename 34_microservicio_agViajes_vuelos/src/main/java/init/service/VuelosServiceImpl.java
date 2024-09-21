package init.service;

import java.util.List;

import init.dao.VuelosDao;
import init.entities.Vuelo;
import init.model.VuelosDto;
import init.utilidades.Mapeador;

public class VuelosServiceImpl implements VuelosService {
	
	private static final Integer Idvuelo = null;
	VuelosDao vuelosDao;
	Mapeador mapeador;
	
	
	
	
	

	public VuelosServiceImpl(VuelosDao vuelosDao, Mapeador mapeador) {
		super();
		this.vuelosDao = vuelosDao;
		this.mapeador = mapeador;
	}

	@Override
	public void actualizarPlazas(int idvuelo, int reservas) {
		   
		vuelosDao.actuazarPlazas(idvuelo, reservas);

	}

	@Override
	public VuelosDto buscarVuelo(int idvuelo) {
		
		Vuelo vuelo = vuelosDao.findById(Idvuelo).orElse(null);
		
		if(vuelo !=null) {
			 
			return mapeador.VuelosEntityToDto(vuelo);
		}
		
		return null;
	}

	@Override
	public List<VuelosDto> listaDeVuelos(String destino, int plazas) {
		// TODO Auto-generated method stub
		return null;
	}

}
