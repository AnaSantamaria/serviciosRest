package init.dao;

import java.util.List;


import org.springframework.data.jpa.repository.Query;

import init.entities.Reserva;

public interface ReservasDao {
	
	@Query("select u from Reserva u where u.usuario=?1")
	List<Reserva> findByusuario(String usuario);

}