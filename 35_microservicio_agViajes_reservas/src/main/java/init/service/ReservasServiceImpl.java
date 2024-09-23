package init.service;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import init.entities.Reserva;
import init.model.HotelDto;
import init.utilidades.Mapeador;

public class ReservasServiceImpl implements ReservasService {
	
	ReservaDao reservaDao;
	Mapeador mapeador;
	
	String url_servicio_vuelo = "http://servicio-vuelos/vuelos/vuelo";
	String url_servicio_hotel = "http://servicio-hoteles/hoteles/hoteles/";
	
	// Para consumirlo necesito un Cliente
	RestClient restClient;
	
	public ReservaServiceImpl(RestClient restClient, ReservaDao reservaDao, Mapeador mapeador) {
		this.restClient = restClient;
		this.reservaDao = reservaDao;
		this.mapeador = mapeador;
	}
	
	// Listas de reservas por cliente
	@Override
	public List<ReservaDto> getReservas(String usuario) {
		return reservaDao.findByusuario(usuario).stream()
		.map(r -> mapeador.reservaEntityToDto(r))
		.toList();
	}
	
	// Para reserva, va a llamar a los microservicios vuelo y hotel para obtener los datos para Vuelo y Hotel
	@Override
	public boolean altaReserva(ReservaDto reserva, int plazas) {
		VueloDto vuelo = getVuelo(reserva.getIdvuelo());
		if(vuelo == null) {
			return false;
		}
		
		HotelDto hotel = getHotel(vuelo.getDestino());
		if(hotel == null) {
			return false;		
		}
		
		// Construyo la reserva:
		reservaDao.save(new Reserva(0,
				mapeador.hotelDtoToEntity(hotel),
				mapeador.vueloDtoToEntity(vuelo),
				vuelo.getPrecio()*plazas,
				reserva.getUsuario()));
		updatePlazas(vuelo.getIdvuelo(),plazas);
		return true;
		
		
	};
	
	// Métodos de apoyo
	
	public VueloDto getVuelo(int id) {
		// Construcción segura de la URL, la concatenación da problemas
	    URI uri = UriComponentsBuilder
	        .fromHttpUrl(url_servicio_vuelo)
	        .pathSegment(String.valueOf(id))
	        .build()
	        .toUri();

		return restClient
			.get()
			.uri(uri) 
			.retrieve()
			.body(VueloDto.class);
	}
	
	public HotelDto getHotel(String localizacion) {
		// Construcción segura de la URL, la concatenación da problemas
	    URI uri = UriComponentsBuilder
	        .fromHttpUrl(url_servicio_hotel)
	        .pathSegment(localizacion)
	        .build()
	        .toUri();

	    // Obtengo los hoteles de la lozalización y me quedo con el primero.
		return Arrays.stream(restClient
			.get()
			.uri(uri) 
			.retrieve()
			.body(HotelDto[].class))
			.findFirst()
			.orElse(null);
	}
	
	public void updatePlazas(int idVuelo, int plazas) {
		URI uri = UriComponentsBuilder
		        .fromHttpUrl(url_servicio_vuelo)
		        .queryParam("idVuelo", idVuelo)
		        .queryParam("plazas", plazas)
		        .build()
		        .toUri();
		
		restClient.get()
        .uri(uri)
        .retrieve()
        .toBodilessEntity();  
	}


}
