package service;

import java.util.List;

import model.Pais;

public interface PaisesService {
	
	/*Microservicio paises

Crear un microservicio cliente del servicio público de paises. Este servicio tendrá dos recursos:

-lista de continentes
-lista de paises del continente cuyo nombre se recibe en url

Cada pais tiene los siguientes campos: nombre,continente,capital, población y bandera */
	
	public List<String> continentes ();
	
	public List <Pais> buscarPaisesPorContinente (String continente);
 
}
