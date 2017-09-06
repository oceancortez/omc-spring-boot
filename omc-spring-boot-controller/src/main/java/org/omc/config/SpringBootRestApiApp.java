package org.omc.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = { "org.omc" })
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@EntityScan(basePackages = "org.omc")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"org.omc.seguro.repository"}, entityManagerFactoryRef = "entityManagerFactoryBean", transactionManagerRef = "transactionManager")
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
	
//    @Bean
//    public DataSource getDataSource() {
//    	org.apache.tomcat.jdbc.pool.DataSource dataSourceConfig = new org.apache.tomcat.jdbc.pool.DataSource();
//                
//        dataSourceConfig.setDriverClassName(env.getRequiredProperty("spring.datasource.driver"));
//        dataSourceConfig.setUrl(env.getRequiredProperty("spring.datasource.url"));
//        dataSourceConfig.setUsername(env.getRequiredProperty("spring.datasource.username"));
//        dataSourceConfig.setPassword(env.getRequiredProperty("spring.datasource.password"));   
// 
//        return new org.apache.tomcat.jdbc.pool.DataSource(dataSourceConfig);
//    }

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}	

	
	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
		return hemf.getSessionFactory();
	}
	
	/***
	 * Usando Spring Data JPA com SessionFactory do hibernate
	 * 
	 */
	@Bean	
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(getDataSource());
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("org.omc");	
		
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		jpaProperties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
		jpaProperties.put("hibernate.current_session_context_class", env.getRequiredProperty("hibernate.current_session_context_class"));	
		
		entityManagerFactoryBean.setJpaProperties(jpaProperties);
		
		return entityManagerFactoryBean;		
	} 

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {		
		return new JpaTransactionManager(emf);
	}
	
	/***
	 * Outra forma de usar o SessionFactory
	 * Quando for usar somente o SessionFactory, use o codigo abaixo com o a property  hibernate.current_session_context_class
	 */
//	@Bean
//	public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
//	    HibernateJpaSessionFactoryBean fact = new HibernateJpaSessionFactoryBean();
//	    fact.setEntityManagerFactory(emf);
//	    return fact;
//	}
	
}
