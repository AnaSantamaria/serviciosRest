package init.service;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import init.dao.ReservasDao;
import init.entities.Hotel;
import init.entities.Reserva;
import init.entities.Vuelo;
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
    public boolean altaReserva(ReservasDto reservaDto, int plazas) {
		
		
        // Obtener vuelo desde el servicio de vuelos
		
        Vuelo vuelo = reservarVuelo(reservaDto.getVuelo().getIdvuelo(), plazas);
        if (vuelo == null) {
            return false;
        }

        // Obtener hotel desde el servicio de hoteles
        Hotel hotel = reservarHotel(vuelo.getDestino());
        if (hotel == null) {
            return false;
        }

        // Calcular precio total
        double precioTotal = (hotel.getPrecio() + vuelo.getPrecio()) * plazas;

        // Crear y guardar la reserva
        Reserva reserva = new Reserva();
        reserva.setHotel(hotel);
        reserva.setVuelo(vuelo);
        reserva.setPrecio(precioTotal);
        reserva.setUsuario(reservaDto.getUsuario());

        reservasDao.save(reserva);

        // Actualizar las plazas del vuelo
        updatePlazas(vuelo.getIdvuelo(), plazas);

        return true;
    }
	
	@Override
	public List<ReservasDto> listaDeReservas (String usuario) {
		return reservasDao.findByusuario(usuario)
				.stream()
				.map(r->mapeador.reservaEntityToDto(r))
				.toList();
		
	}
		

    // Método para obtener vuelo desde el microservicio de vuelos
	
    public Vuelo reservarVuelo(int idVuelo, int plazas) {
        URI uri = UriComponentsBuilder
            .fromHttpUrl(urlVuelos)
            .pathSegment(String.valueOf(idVuelo))
            .build()
            .toUri();

        return restClient
            .get()
            .uri(uri)
            .retrieve()
            .body(Vuelo.class);
    }

    // Método para obtener hotel desde el microservicio de hoteles
    public Hotel reservarHotel(String localizacion) {
        URI uri = UriComponentsBuilder
            .fromHttpUrl(urlHoteles)
            .pathSegment("buscarLocalizacion", localizacion)
            .build()
            .toUri();

        return restClient
            .get()
            .uri(uri)
            .retrieve()
            .body(Hotel.class);
    }

    // Método para actualizar las plazas en el microservicio de vuelos
    public void updatePlazas(int idVuelo, int plazas) {
        URI uri = UriComponentsBuilder
            .fromHttpUrl(urlVuelos)
            .pathSegment("actualizarPlazas")
            .queryParam("idVuelo", idVuelo)
            .queryParam("plazas", plazas)
            .build()
            .toUri();

        restClient
            .put()
            .uri(uri)
            .retrieve();
    }

	
		
	}
	
