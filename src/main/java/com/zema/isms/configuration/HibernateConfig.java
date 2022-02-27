/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.configuration;



import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import javax.sql.DataSource;

;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import org.springframework.transaction.annotation.EnableTransactionManagement;

/**a
 *
 * @author ewawuye
 */
@Configuration

@PropertySource("classpath:database.properties")
@EnableTransactionManagement
@ComponentScan(basePackages ={"com.zema.isms.dao","com.zema.isms.service"})
public class HibernateConfig {
   @Autowired
	private Environment environment;

      @Bean
    public LocalSessionFactoryBean getSessionFactory() throws PropertyVetoException {
          final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
       
        sessionFactory.setPackagesToScan(new String[] { "com.zema.isms.domain" });

        sessionFactory.setHibernateProperties(hibernateProperties());
        
        
          return sessionFactory;
      
    }

  /*  @Bean
    public BasicDataSource dataSource() {
        BasicDataSource ds = new  BasicDataSource();
              ds.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		ds.setUrl(environment.getRequiredProperty("jdbc.url"));
		ds.setUsername(environment.getRequiredProperty("jdbc.username"));
		ds.setPassword(environment.getRequiredProperty("jdbc.password"));
		return ds;
         
        
    } */
        @Bean
    public DataSource dataSource() throws PropertyVetoException  {
    	ComboPooledDataSource dataSource = new ComboPooledDataSource();
    	
        

         
    	dataSource.setDriverClass(environment.getRequiredProperty("jdbc.driverClassName"));
    	dataSource.setJdbcUrl(environment.getRequiredProperty("jdbc.url"));
    	dataSource.setUser(environment.getRequiredProperty("jdbc.username"));
    	dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        
    	dataSource.setAcquireIncrement(10);
    	dataSource.setIdleConnectionTestPeriod(0);
    	dataSource.setInitialPoolSize(5);
    	dataSource.setMaxIdleTime(30);
    	dataSource.setMaxPoolSize(50);
    	dataSource.setMaxStatements(100);
    	dataSource.setMinPoolSize(5);
    	
    	return dataSource;
    }
    
    

    private Properties hibernateProperties() {
        Properties properties = new Properties();
       properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
           properties.put("hibernate.connection.characterEncoding",environment.getRequiredProperty("hibernate.connection.characterEncoding"));
           properties.put("hibernate.connection.charSet", environment.getRequiredProperty("hibernate.connection.charSet"));
             properties.put("hibernate.connection.useUnicode", environment.getRequiredProperty("hibernate.connection.useUnicode"));
      properties.put("hibernate.current_session_context_class","org.springframework.orm.hibernate5.SpringSessionContext");        
    properties.put("connection.provider_class","org.hibernate.connection.C3P0ConnectionProvider");
//    properties.put("hibernate.c3p0.min_size",10);
//    properties.put("hibernate.c3p0.max_size",50);
//    properties.put("hibernate.c3p0.acquire_increment",5);
//    properties.put("hibernate.c3p0.idle_test_period",600);
//    properties.put("hibernate.c3p0.timeout",5000);
        return properties;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() throws PropertyVetoException {
      final  HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    } 
     
}
