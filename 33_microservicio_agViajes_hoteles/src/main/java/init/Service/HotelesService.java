package init.Service;

import java.util.List;

import init.dto.HotelDto;
import init.entities.Hotel;

public interface HotelesService {
	
	
	
	   HotelDto buscarPorId (int idHotel);
	   
	   List<HotelDto> buscarPorLocalizacion (String localizacion);

}
