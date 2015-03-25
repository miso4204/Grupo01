package com.uniandes.stampidia.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.uniandes.stampidia")
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("com.uniandes.stampidia.repos")
public class PersistencesJPAConfig {
	
	/**
	 * TODO estas constantes se deben pasar a la enumeracion Constantes
	 */
	private static final String ENV_DEBUG = "debug";
	
	private static final String DATABASE_DRIVER = "db.driver";
	
	private static final String PROD_DATABASE_URL = "db.url";
	private static final String PROD_DATABASE_USERNAME = "db.username";
	private static final String PROD_DATABASE_PASSWORD = "db.password";
	
	private static final String DEV_DATABASE_URL = "db.dev.url";
	private static final String DEV_DATABASE_USERNAME = "db.dev.username";
	private static final String DEV_DATABASE_PASSWORD = "db.dev.password";

//    private static final String PROPERTY_NAME_HIBERNATE_URL = "hibernate.connection.url";
//    private static final String PROPERTY_NAME_HIBERNATE_SCHEMA = "hibernate.default_schema";
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";

    @Resource
    private Environment env;
    
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(hibProperties());

		return em;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty(DATABASE_DRIVER));
		
		Boolean debug = Boolean.valueOf(env.getRequiredProperty(ENV_DEBUG));
		if(!debug){
			dataSource.setUrl(env.getRequiredProperty(PROD_DATABASE_URL));
			dataSource.setUsername(env.getRequiredProperty(PROD_DATABASE_USERNAME));
			dataSource.setPassword(env.getRequiredProperty(PROD_DATABASE_PASSWORD));
		}else{
			dataSource.setUrl(env.getRequiredProperty(DEV_DATABASE_URL));
			dataSource.setUsername(env.getRequiredProperty(DEV_DATABASE_USERNAME));
			dataSource.setPassword(env.getRequiredProperty(DEV_DATABASE_PASSWORD));
		}
		
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	public Properties hibProperties() {
//      Otras propiedades que se pueden usar..		
//		properties.put(PROPERTY_NAME_HIBERNATE_URL, env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
//		properties.put(PROPERTY_NAME_HIBERNATE_SCHEMA, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SCHEMA));
//		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		Properties properties = new Properties();
		properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));

		return properties;
	}

	
	@Bean
	public MultipartResolver multipartResolver(){
		
		return new CommonsMultipartResolver();
	}
}
