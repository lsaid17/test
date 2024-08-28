package com.test.api.client;

import org.springframework.cloud.openfeign.FeignClient;

import com.test.api.config.FeignClientConfiguration;
import com.test.api.dto.GetCardBalanceResponse;
import com.test.api.dto.GetCardInformationResponse;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

@FeignClient(name = "card", configuration = FeignClientConfiguration.class)
public interface CardClient {
	
	@RequestLine("GET /card/getInformation/{card}")
	@Headers("Content-Type: application/json")
	GetCardInformationResponse getInformation(@Param("card") String card);

	@RequestLine("GET /card/getBalance/{card}")
	@Headers("Content-Type: application/json")
	GetCardBalanceResponse getBalance(@Param("card") String card);
}
