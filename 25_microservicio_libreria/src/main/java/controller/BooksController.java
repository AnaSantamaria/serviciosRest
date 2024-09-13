package controller;

import java.awt.print.Book;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import service.BooksService;

public class BooksController {
	
	BooksService libreriaService;

	public BooksController(BooksService libreriaService) {
		super();
		this.libreriaService = libreriaService;
	}
	
	@GetMapping(value="librosPorPrecio/{min}/{max}", produces=MediaType.APPLICATION_JSON_VALUE)
	
	public List<model.Book> buscarPorPrecio(@PathVariable("min") double min,@PathVariable("max") double max){
										
		return libreriaService.buscarPorRangoDePrecio(min, max);
	} 
}


