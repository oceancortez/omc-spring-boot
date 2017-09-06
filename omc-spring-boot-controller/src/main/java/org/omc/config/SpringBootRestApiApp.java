package org.omc.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiTemplate;

@SpringBootApplication(scanBasePackages = { "org.omc" })
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@EntityScan(basePackages = "org.omc")
public class SpringBootRestApiApp extends SpringBootServletInitializer {
	
	@Autowired
	private Environment env; 
	
	public static void main(String[] args) {		
		SpringApplication.run(SpringBootRestApiApp.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootRestApiApp.class);
	}

	@Bean
	public DataSource getDataSource() {		
		DataSource dataSource = null;
		JndiTemplate jndi = new JndiTemplate();
		
		try {
			dataSource = jndi.lookup(env.getProperty("app.datasource.jndi-name"), DataSource.class);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return dataSource;
	}

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}
	
	@Bean
	public SessionFactory getSessionFactory(HibernateEntityManagerFactory hemf) {
		return hemf.getSessionFactory();
	}

}
