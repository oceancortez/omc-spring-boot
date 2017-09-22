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
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mongodb.Mongo;

@SpringBootApplication(scanBasePackages = { "org.omc" })
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@EntityScan(basePackages = "org.omc")
@EnableMongoRepositories(basePackages = "org.omc.seguro.repository.mongo")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
		"org.omc.seguro.repository" }, entityManagerFactoryRef = "entityManagerFactoryBean", transactionManagerRef = "transactionManager")
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

	public @Bean DataSource getDataSource() {
		DataSource dataSource = null;
		JndiTemplate jndi = new JndiTemplate();

		try {
			dataSource = jndi.lookup(env.getProperty("app.datasource.jndi-name"), DataSource.class);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return dataSource;
	}

	// /**
	// *
	// * @getDataSource apenas para exutar test pelo Junit
	// */
	// @Bean
	// public DataSource getDataSource() {
	// DriverManagerDataSource dataSourceConfig = new DriverManagerDataSource();
	//
	// dataSourceConfig.setDriverClassName(env.getRequiredProperty("spring.datasource.driver"));
	// dataSourceConfig.setUrl(env.getRequiredProperty("spring.datasource.url"));
	// dataSourceConfig.setUsername(env.getRequiredProperty("spring.datasource.username"));
	// dataSourceConfig.setPassword(env.getRequiredProperty("spring.datasource.password"));
	//
	// return dataSourceConfig;
	// }

	public @Bean JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}

	public @Bean SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
		return hemf.getSessionFactory();
	}

	/***
	 * Usando Spring Data JPA com SessionFactory do hibernate
	 * 
	 */
	public @Bean LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(getDataSource());
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("org.omc");

		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		jpaProperties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
		jpaProperties.put("hibernate.current_session_context_class",
				env.getRequiredProperty("hibernate.current_session_context_class"));

		entityManagerFactoryBean.setJpaProperties(jpaProperties);

		return entityManagerFactoryBean;
	}

	public @Bean JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

	@SuppressWarnings("deprecation")
	public @Bean MongoDbFactory mongoDbFactory() throws Exception {
	
		UserCredentials userCredentials = 
				new UserCredentials(env.getRequiredProperty("omc.mongo.user"),
									env.getRequiredProperty("omc.mongo.password"));
		
		return new SimpleMongoDbFactory(new Mongo("localhost"), env.getRequiredProperty("omc.mongo.database"), userCredentials);
	}

	
	public @Bean MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory, MongoMappingContext context) {

		return new MongoTemplate(mongoDbFactory);
	}

	/***
	 * Outra forma de usar o SessionFactory Quando for usar somente o
	 * SessionFactory, use o codigo abaixo com o a property
	 * hibernate.current_session_context_class
	 */
	// @Bean
	// public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory
	// emf) {
	// HibernateJpaSessionFactoryBean fact = new
	// HibernateJpaSessionFactoryBean();
	// fact.setEntityManagerFactory(emf);
	// return fact;
	// }

}
