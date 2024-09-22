package init.Service;

import java.util.List;

import init.entities.Hotel;
import init.model.HotelDto;

public interface HotelesService {
	
	
	
	   HotelDto buscarPorId (int idHotel);
	   
	   List<HotelDto> buscarPorLocalizacion (String localizacion);

}
