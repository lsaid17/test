package com.test.api.config;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.test.api.client.CardClient;

import feign.Feign;
import feign.Logger;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@Configuration
public class FeignClientConfiguration {

	@Autowired
	protected Environment env;

	@Bean
	public Logger.Level logLevel() {
		return Logger.Level.FULL;
	}
	@Bean
	public Encoder encoder() {
		return new JacksonEncoder();
	}

	@Bean
	public Decoder decoder() {
		return new JacksonDecoder();
	}
	
	@Bean
	public CardClient FeignClient() throws KeyManagementException, NoSuchAlgorithmException {
		return Feign.builder().encoder(encoder()).decoder(decoder())
				.requestInterceptor(new HeaderRequestInterceptor()).logLevel(Logger.Level.FULL)
				.target(CardClient.class, env.getProperty("base.url.api"));
	}

}
