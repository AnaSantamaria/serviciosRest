package utilidaddes;

import model.Book;
import model.LibroJson;

public class Mapeador {
	
	public Book jsonToBook(LibroJson libro) {
		
		int clasificacion= getClasificacion(libro.getPaginas());
		
		return new Book(libro.getTitulo(), libro.getTemaJson().getNombreTema(), libro.getPrecio(),clasificacion);  // en el parametro clasificacion, se guarda el resultado del metodo privado
		
		
	}
		private int getClasificacion(int paginas) {// metodo privado para obtener la clasificacion en funcion de las paginas
			
			if (paginas>0 && paginas<=100) {
				
				return 1;
			}
			
			else if (paginas>100 && paginas <=200) {
				
				return 2;
			}
			
			else {
				
				return 3;
			}
		}
}
