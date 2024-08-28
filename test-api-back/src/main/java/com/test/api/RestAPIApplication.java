package com.test.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;

import com.test.api.config.JpaConfig;

@SpringBootApplication
@Import({ JpaConfig.class })
@ComponentScan(basePackages = { "com.test.api.*", "com.test.api.repository", "com.test.api.config" })
@PropertySource("file://${rest.api.dir}/properties/config-application.properties")
@PropertySource("file://${rest.api.dir}/properties/config-data.properties")
@PropertySource("file://${rest.api.dir}/properties/config-database.properties")
@EnableAsync
public class RestAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestAPIApplication.class, args);
	}
}