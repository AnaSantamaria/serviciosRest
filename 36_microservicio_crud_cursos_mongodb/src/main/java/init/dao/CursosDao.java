package init.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import init.entities.Curso;

public interface CursosDao extends MongoRepository<Curso, String> {
	
	//recuperar curso por nombre
	
	Curso findByCurso(String n);
	//cursos de duracion inferior al parametro
	
	@Query("{'duracion':{'$lt':?0}}")
	List<Curso> findByDuracionMaxima(int max);
	
	//eliminar curso por nombre
	
	
	void deleteByCurso (String c);

}
