/**
 * 
 */
package omc.pedidos.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ocean
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"omc"})
public class SampleApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}
}
