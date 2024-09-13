package service;

import java.util.List;

import model.Book;

public interface BooksService {
	
	List <Book> buscarPorRangoDePrecio(double min, double max);
	
		
	

}
