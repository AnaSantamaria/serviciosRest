package service;

import java.util.List;

import dao.BuscadorDao;
import entities.Resultado;
import model.ResultadoDto;
import utilidades.Mapeador;

public class BuscadorServiceImpl implements BuscadorService {
	
	BuscadorDao buscadorDao;
	Mapeador mapeador;
	
	
	public BuscadorServiceImpl(BuscadorDao buscadorDao, Mapeador mapeador) {
		super();
		this.buscadorDao = buscadorDao;
		this.mapeador = mapeador;
	}

	@Override
	public List<ResultadoDto> buscar(String url) {
		
		return buscadorDao.findByTematica(url).stream()
				.map(r->mapeador.resultadoEntityToDto(r))
				.toList();
	}

	@Override
	public boolean agregar(ResultadoDto resultado) {
		
		Resultado r=mapeador.resultadoDtoToEntity(resultado);
		if(buscadorDao.findByUrl(r.getUrl())==null) {
			buscadorDao.save(r);
			return true;
		}
		return false;
	}

}
