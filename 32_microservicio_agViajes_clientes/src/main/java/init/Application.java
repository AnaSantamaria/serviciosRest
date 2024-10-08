package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableEurekaServer 
@EnableJpaRepositories(basePackages = {"dao"})
@EntityScan(basePackages = {"entities"})
@SpringBootApplication(scanBasePackages = {"controller","service"})
public class Application{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
