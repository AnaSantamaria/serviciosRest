package init.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import init.entities.Reserva;
import init.entities.Vuelo;

public interface ReservasDao extends JpaRepository <Reserva,Integer>{
	
	@Query("select u from Reserva u where u.usuario=?1")
	List<Reserva> findByusuario(String usuario);

	

}