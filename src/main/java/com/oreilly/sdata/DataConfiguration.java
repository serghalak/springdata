package com.oreilly.sdata;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration
//@EnableJpaRepositories("com.oreilly.sdata")
//@EnableTransactionManagement
//@ComponentScan("com.oreilly.sdata")
//@PropertySource("classpath:app.properties")
public class DataConfiguration {
	//@Value("${db.driver}")
	private static final String PROP_DATABASE_DRIVER = "db.driver";
    private static final String PROP_DATABASE_PASSWORD = "db.password";
    private static final String PROP_DATABASE_URL = "db.url";
    private static final String PROP_DATABASE_USERNAME = "db.username";
    private static final String PROP_HIBERNATE_DIALECT = "db.hibernate.dialect";
    private static final String PROP_HIBERNATE_SHOW_SQL = "db.hibernate.show_sql";
    private static final String PROP_ENTITYMANAGER_PACKAGES_TO_SCAN = 
    		"db.entitymanager.packages.to.scan";
    private static final String PROP_HIBERNATE_HBM2DDL_AUTO = "db.hibernate.hbm2ddl.auto";
	
    private static final String APP_FILE_PROPERTIES="app.properties";
//    @Resource
//    private Enviroment env;
    
    
	@Bean
	public DataSource dataSource(){
		
		//for mysql
		//DriverManagerDataSource dataSource = new DriverManagerDataSource();

//        dataSource.setDriverClassName(env.getRequiredProperty(PROP_DATABASE_DRIVER));
//        dataSource.setUrl(env.getRequiredProperty(PROP_DATABASE_URL));
//        dataSource.setUsername(env.getRequiredProperty(PROP_DATABASE_USERNAME));
//        dataSource.setPassword(env.getRequiredProperty(PROP_DATABASE_PASSWORD));
		
		//for h2
		EmbeddedDatabaseBuilder builder=new EmbeddedDatabaseBuilder();
		return builder.setType(EmbeddedDatabaseType.H2).build();		
	} 
	
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
//		
//		HibernateJpaVendorAdapter vendorAdapter=new HibernateJpaVendorAdapter();
//		vendorAdapter.setGenerateDdl(true);			
//		
//		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean=
//				new LocalContainerEntityManagerFactoryBean();
//		Properties prop=getHibernateProperties();
//		//entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
//		entityManagerFactoryBean.setPackagesToScan(
//				(String[]) prop.get(PROP_ENTITYMANAGER_PACKAGES_TO_SCAN));
//		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
//		entityManagerFactoryBean.setDataSource(dataSource());
//		entityManagerFactoryBean.setJpaProperties(prop);
//		entityManagerFactoryBean.afterPropertiesSet();
//		
//		return entityManagerFactoryBean;
//		
//	}
	
	//for H2 database
	@Bean
	public EntityManagerFactory entityManagerFactory(){
		HibernateJpaVendorAdapter vendorAdapter=new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		Properties prop=new Properties();
		prop.put("hibernate.hbm2ddl.auto", "create-drop");
		prop.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean=
				new LocalContainerEntityManagerFactoryBean();
		
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan("com.oreilly.sdata");
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactoryBean.afterPropertiesSet();
		
		return entityManagerFactoryBean.getObject();
		
	}
	
	
	
//	@Bean
//	public JpaTransactionManager TransactionManager(){
//		JpaTransactionManager transactionManager=new JpaTransactionManager();
//		transactionManager.setEntityManagerFactory(entityManagerFactory());
//		return transactionManager;
//	}
	@Bean
	public PlatformTransactionManager transactionManager(){
		JpaTransactionManager transactionManager=new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory());
		return transactionManager;
	}
	
	 private Properties getHibernateProperties() {
        
		 Properties properties = new Properties();
		 String resourceName = APP_FILE_PROPERTIES;//"app.properties"; // could also be a constant
		 ClassLoader loader = Thread.currentThread().getContextClassLoader();
		 Properties props = new Properties();
		 try(InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
		     props.load(resourceStream);
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
        //properties.put(PROP_HIBERNATE_DIALECT, env.getRequiredProperty(PROP_HIBERNATE_DIALECT));
        //properties.put(PROP_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROP_HIBERNATE_SHOW_SQL));
        //properties.put(PROP_HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(PROP_HIBERNATE_HBM2DDL_AUTO));

        properties.put(PROP_HIBERNATE_DIALECT, props.get(PROP_HIBERNATE_DIALECT));
        properties.put(PROP_HIBERNATE_SHOW_SQL, props.get(PROP_HIBERNATE_SHOW_SQL));
        properties.put(PROP_HIBERNATE_HBM2DDL_AUTO, props.get(PROP_HIBERNATE_HBM2DDL_AUTO));
        
        return properties;
	    }

}
