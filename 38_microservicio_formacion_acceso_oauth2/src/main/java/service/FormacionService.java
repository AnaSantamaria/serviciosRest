package service;

import java.util.List;

import model.Curso;

public interface FormacionService {
	
	List<Curso> buscarPorArea (String area);
	void altaFormacion(Curso curso);
		
		
	}


