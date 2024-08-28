package com.test.api.config;

import java.util.Map;

import org.slf4j.MDC;
import org.springframework.http.HttpHeaders;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class HeaderRequestInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate template) {
		Map<String, String> headers = MDC.getCopyOfContextMap();
		if (headers != null) {
			template.header(HttpHeaders.AUTHORIZATION, "Bearer "+ MDC.get("Authorization"));
		}
	}

}
