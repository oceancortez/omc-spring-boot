package org.omc.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages= {"org.omc"})
/***
 * Por default o boot procura conexao com dataSource, apenas exlui isso para pode subir o spring
 * @DataSourceAutoConfiguration @HibernateJpaAutoConfiguration
 *
 */
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class SpringBootRestApiApp extends SpringBootServletInitializer {
	

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootRestApiApp.class);
    }
		
		public static void main(String[] args) {
	        SpringApplication.run(SpringBootRestApiApp.class, args);
	    }
		
}
