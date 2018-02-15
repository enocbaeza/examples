package com.futbolacademy.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.futbolacademy.config" })
public class HibernateConfig {

	@Bean
	public LocalSessionFactoryBean sessionFactoryBean(){
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan("com.futbolacademy.model");
		sessionFactoryBean.setHibernateProperties(hibernateProperties());  
		return sessionFactoryBean;
	}
 
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/deportivo_temuco");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory session) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(session);
		return transactionManager;
	}
	 
	private Properties hibernateProperties() {
		Properties property = new Properties();
		property.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		property.put("hibernate.sql.show", "true");
		property.put("hibernate.sql.format", "false");
		return property;
	}
}
