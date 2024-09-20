package init.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import init.dao.HotelesDao;
import init.dto.HotelDto;
import init.entities.Hotel;
import init.utilidades.Mapeador;
@Service
public class HotelesServiveImpl implements HotelesService {
	
	HotelesDao hotelesDao;
	Mapeador mapeador;

	
	
	public HotelesServiveImpl(HotelesDao hotelesDao, Mapeador mapeador) {
		super();
		this.hotelesDao = hotelesDao;
		this.mapeador = mapeador;
	}

	@Override
	public HotelDto buscarPorId(int idHotel) {
		
		return hotelesDao.findById(idHotel)
		.map(h->mapeador.hotelEntityToDto(h))
				.orElse(null);
		
		 
	}

	@Override
	public List<HotelDto> buscarPorLocalizacion(String localizacion) {
		
		
		
		return hotelesDao.findByLocalizacion(localizacion)
				.stream()
				.map(h->mapeador.hotelEntityToDto(h))
				.toList();
	}

}
