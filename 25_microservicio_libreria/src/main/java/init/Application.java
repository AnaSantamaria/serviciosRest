package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication(scanBasePackages = {"service","controller"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestClient.Builder getBuilder(){// para llamar, por eso dsolo se hace en el que va a llamar, no en el que se registra en Eureka
		
		return RestClient.builder();
	}
	
	@Bean
	public RestClient getClient() {//metodo para poder crear el bjeto RetClient que utilizamos en el service para hacer la llamada al servicio que queramos
		
		return RestClient.create();
	}


}
