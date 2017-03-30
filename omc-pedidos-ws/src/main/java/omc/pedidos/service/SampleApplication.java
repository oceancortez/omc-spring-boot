/**
 * 
 */
package omc.pedidos.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ocean
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"omc"})
public class SampleApplication extends SpringBootServletInitializer {
	
		@Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(SampleApplication.class);
	    }
	
	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}
}
