package service;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestClient;

import model.Book;
import model.LibroJson;
import utilidaddes.Mapeador;

public class BooksServiceImpl implements BooksService {
	
	String url="http://servicio-libros/libros";//servicio-libros esto se pone para que llame en Eureka
	RestClient restClient;
	Mapeador mapeador;
	
	

	public BooksServiceImpl(String url, RestClient restClient, Mapeador mapeador) {
		super();
		this.url = url;
		this.restClient = restClient;
		this.mapeador = mapeador;
	}





	@Override
	public List<Book> buscarPorRangoDePrecio(double min, double max) {

		return 
				Arrays.stream
				(restClient
						.get()
						.uri(url+"/catalogo")
						.retrieve()
						.body(LibroJson[].class))
				.map(l->mapeador.jsonToBook(l))
				.filter(l->l.getPrecio()>=min && l.getPrecio()<=max)
				.toList(); 
	}

}
