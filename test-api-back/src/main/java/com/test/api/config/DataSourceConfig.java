package com.test.api.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import lombok.Getter;
import lombok.Setter;


@Configuration
@ConfigurationProperties(prefix = "acs.api", ignoreUnknownFields = true)
@PropertySource("file:${rest.api.dir}properties/config-database.properties")
@Setter
@Getter
public class DataSourceConfig{
	
	private String url;
	private String username;
	private String password;
	private String driverClassName;
	private String dialect;
	private String default_schema;
	private String packages = "com.test.api.models";

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setSchema(default_schema);
        return dataSource;
    }
}
