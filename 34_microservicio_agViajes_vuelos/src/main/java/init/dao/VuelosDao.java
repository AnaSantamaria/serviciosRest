package init.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import init.entities.Vuelo;

public interface VuelosDao extends JpaRepository <Vuelo,Integer> {
	
	

	
	
	
	List <Vuelo> findByDestinoYPlazas (String detino, int plazas);
	
	 @Modifying
	 @Transactional
	 @Query("UPDATE Vuelo v SET v.plazas = v.plazas - ?2 WHERE v.idvuelo = ?1")
	void actuazarPlazas (int idvuelo, int plazas);

	 
}
