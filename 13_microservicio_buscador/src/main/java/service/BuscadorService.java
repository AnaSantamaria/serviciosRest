package service;

import java.util.List;

import model.ResultadoDto;

public interface BuscadorService {
	
	List<ResultadoDto> buscar(String url);
	boolean agregar(ResultadoDto resultado);
	
	

}
