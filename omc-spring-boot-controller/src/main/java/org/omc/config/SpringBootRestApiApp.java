package org.omc.config;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;


@SpringBootApplication(scanBasePackages= {"org.omc"})
/***
 * Por default o boot procura conexao com dataSource, apenas exlui isso para pode subir o spring
 * @DataSourceAutoConfiguration @HibernateJpaAutoConfiguration
 *
 */
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SpringBootRestApiApp extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiApp.class, args);
	}

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootRestApiApp.class);
    }
	
	//Para usar somente a implementacao do Hibernate na SessionFactory
	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
	    HibernateJpaSessionFactoryBean fact = new HibernateJpaSessionFactoryBean();
	    fact.setEntityManagerFactory(emf);
	    return fact;
	}
	   
		
		
		
		
}
