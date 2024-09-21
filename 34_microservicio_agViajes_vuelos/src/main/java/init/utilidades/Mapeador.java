package init.utilidades;

import init.entities.Vuelo;
import init.model.VuelosDto;

public class Mapeador {
  
	VuelosDto vuelosDto;

	public Mapeador(VuelosDto vuelosDto) {
		super();
		this.vuelosDto = vuelosDto;
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
