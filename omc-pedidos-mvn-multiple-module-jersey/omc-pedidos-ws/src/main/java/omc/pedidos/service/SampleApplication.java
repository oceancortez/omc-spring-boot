/**
 * 
 */
package omc.pedidos.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author ocean
 *
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"omc"})
@EntityScan(basePackages = {"omc"})
@ComponentScan(basePackages = {"omc"})
@Configuration
public class SampleApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}
	
//	@Bean
//    public static WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/api/**");
//            }
//        };
//    }
	


}
