package init.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import init.dao.CursosDao;
import init.entities.Curso;
@Service
public class CursosServiceImpl implements CursosService {
	
	CursosDao cursosDao;
	
	

	public CursosServiceImpl(CursosDao cursosDao) {
		super();
		this.cursosDao = cursosDao;
	}

	@Override
	public boolean guardarCurso(Curso curso) {
		
		if(cursosDao.findByCurso(curso.getCurso())!=null) {
			
			return false;
		}
		cursosDao.save(curso);
		return true;
			}

	@Override
	public List<Curso> cursosPorDuracionMaxima(int max) {
		 
		return cursosDao.findByDuracionMaxima(max);
	}

	@Override
	public List<Curso> catalogo() {
		
		 return cursosDao.findAll();
	}

	@Override
	public boolean eliminarCurso(@RequestBody  String curso) {
		
		if(cursosDao.findByCurso(curso)==null){
			return false;
			
		}
		cursosDao.deleteByCurso(curso);
		return true;
		
		//return cursosDao.deleteByCurso(curso);;
	}

}
