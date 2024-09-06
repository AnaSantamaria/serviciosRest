package service;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import model.Pais;
@Service
public class PaisesServiceImpl implements PaisesService {
	
	String url="https://restcountries.com/v2/all";
	
	@Autowired
	RestClient restClient;
	
	
	
	@Override
	public List<String> continentes() {
		
		return Arrays.stream(restClient
		.get()
		.uri(url)
		.retrieve()// me de lista completa de objetos pais
		.body(Pais[].class)//quiero un array de objetos pais y por eso lo convierto en Array.stream al principio. Luego filtro lo que quiera con map
		)
		.map(p->p.getContinente())
		.distinct()
		.toList();
		
		
	}

	@Override
	public List<Pais> buscarPaisesPorContinente(String continente) {
		return Arrays.stream(restClient
				.get()
				.uri(url)
				.retrieve()// me de lista completa de objetos pais
				.body(Pais[].class)//quiero un array de objetos pais y por eso lo convierto en Array.stream al principio. Luego filtro lo que quiera con map
				)
				.filter(p->p.getContinente().equals(continente))
				.toList();
		
	}

}
