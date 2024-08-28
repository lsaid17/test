package com.test.api.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(basePackages = "com.test.api.repository")
public class JpaConfig {
	 @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
	        DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {	    
	        LocalContainerEntityManagerFactoryBean factoryBean = 
	            new LocalContainerEntityManagerFactoryBean();
	        factoryBean.setDataSource(dataSource);
	        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
	        factoryBean.setPackagesToScan("com.test.api.models");
	        return factoryBean;
	    }

	    @Bean
	    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
	        return new JpaTransactionManager(entityManagerFactory);
	    }
}
