package co.com.ceiba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"co.com.ceiba.*"})
@EnableJpaRepositories("co.com.ceiba")
@EntityScan("co.com.ceiba.*")
public class ParqueaderoCeibaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParqueaderoCeibaApplication.class, args);
	}
	
	

}
