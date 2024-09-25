package init.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import init.entities.Hotel;

public interface HotelesDao extends JpaRepository<Hotel,Integer> {
	
	
//añadir lista de destinos
	
	List<Hotel> findByLocalizacion(String localizacion);
	
	@Query("SELECT DISTINCT h.localizacion FROM Hotel h")
    List<String> findDistinctDestinos();
 
}
