package cliente;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

// programa de escritorio para llamr a un servicio creado( 01_ejemplo_res)
public class ClienteEjemplo {

	public static void main(String[] args) {
		
		String url="http://localhost:8080/01_ejemplo_rest/pruebas";  // Primero hay que poner la direccion de referencia del servicio

		WebTarget wt=ClientBuilder
				.newClient()// Client
				.target(url);//WebTarget
		
		// hacemos las llamadas a los recursos con el webtarget que ya tenemos 
		
		String mensaje1=wt
		.path("/saludar")//aquí pones la direccion de llamada
		.request(MediaType.TEXT_PLAIN)//peticion. Es para decir que tipo de respuesta esparas
		.get(String.class);// String porque lo que estamos manejando son textos. Es decir, si manejaseo numeros sería int, etc...
		
		System.out.println(mensaje1);
		
		
		
		String mensaje2=wt
				.path("/saludar/ana")//aquí pones la direccion de llamada
				.request(MediaType.TEXT_PLAIN)//peticion. Es para decir que tipo de respuesta esparas
				.get(String.class);// String porque lo que estamos manejando son textos. Es decir, si manejaseo numeros sería int, etc...
				
				System.out.println(mensaje2);
				
				
				
				String mensaje3=wt
						.path("/info")//aquí pones la direccion de llamada
						.queryParam("name", "pepe")//WebTarget
						.queryParam("age", 20)//WebTarget
						.request(MediaType.TEXT_PLAIN)//peticion. Es para decir que tipo de respuesta esparas
						.get(String.class);// String porque lo que estamos manejando son textos. Es decir, si manejaseo numeros sería int, etc...
						
						System.out.println(mensaje3);
	}
	
}
