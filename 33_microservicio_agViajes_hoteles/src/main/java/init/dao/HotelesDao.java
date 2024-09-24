package init.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import init.entities.Hotel;

public interface HotelesDao extends JpaRepository<Hotel,Integer> {
	
	
//añadir lista de destinos
	
	List<Hotel> findByLocalizacion(String localizacion);
	
}
