/**
 * 
 */
package omc.pedidos.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author ocean
 *
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"omc"})
@EntityScan(basePackages = {"omc"})
@ComponentScan(basePackages = {"omc"})
public class SampleApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}
	


}
