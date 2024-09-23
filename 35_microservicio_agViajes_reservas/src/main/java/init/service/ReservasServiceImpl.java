package init.service;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import init.dao.ReservasDao;
import init.model.HotelDto;
import init.model.ReservasDto;
import init.model.VuelosDto;
import init.utilidades.Mapeador;

public class ReservasServiceImpl implements ReservasService {
	
	String urlVuelos="http://servicio-vuelos/vuelos/";
	String urlHoteles="http://servicio-hoteles/hoteles/";
			
			
	@Autowired
	ReservasDao reservasDao;
	@Autowired
	Mapeador mapeador;
	@Autowired
	RestClient restClient;
	
	@Override
	public boolean altaReserva(HotelDto hotel, int plazas) {
		
		
		
		
		return false;
	}

	@Override
	public List<ReservasDto> listaDeReservas(String usuario) {
		
		return reservasDao.findByusuario(usuario)
				.stream()
				.map(r->mapeador.resrevaEntityToDto(r))
				.toList();
	}
  //Metodos auxiliar
	public HotelDto reservarHotel (String localizacion) {
		URI uri = UriComponentsBuilder
	            .fromHttpUrl(urlHoteles)
	            .pathSegment("buscarLocalizacion")
	            .queryParam("localizacion", localizacion)
	            .build()
	            .toUri();

	    return Arrays.stream(restClient.get()
	            .uri(uri)
	            .retrieve()
	            .body(HotelDto[].class))
	            .findFirst()
	            .orElse(null);
	}
		
		
		
		
	
	//metodo auxiliar
	public VuelosDto reservarVuelo (int idvuelo, int plazas) {
		URI uri = UriComponentsBuilder
	            .fromHttpUrl(urlVuelos)
	            .pathSegment("disponibilidad")
	            .queryParam("idVuelo", idvuelo)
	            .queryParam("plazas", plazas)
	            .build()
	            .toUri();

	    return restClient.get()
	            .uri(uri)
	            .retrieve()
	            .body(VuelosDto.class);
	}
	
	//metodo auxiliar
	public void actualizarPlazasVuelo(int idvuelo, int plazas) {
	    URI uri = UriComponentsBuilder
	            .fromHttpUrl(urlVuelos)
	            .pathSegment("actualizarPlazas")
	            .queryParam("idvuelo", idvuelo)
	            .queryParam("plazas", plazas)
	            .build()
	            .toUri();

	    restClient.put()
	            .uri(uri)
	            .retrieve()
	            .toBodilessEntity();
	}
		
	}
	
