package com.test.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.test.api.client.CardClient;
import com.test.api.dao.LogInformationDao;
import com.test.api.dto.CardAllInformationResponse;
import com.test.api.dto.GetCardBalanceResponse;
import com.test.api.dto.GetCardInformationResponse;
import com.test.api.models.LogInformation;

import feign.FeignException;

@Service
public class CardService {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private LogInformationDao logInformationdao;

	@Autowired
	private CardClient cardClient;

	@Autowired
	protected Environment env;

	public CardAllInformationResponse getCardInformation(String card) {
		MDC.put(HttpHeaders.AUTHORIZATION, env.getProperty("api.token"));
		CardAllInformationResponse result = new CardAllInformationResponse();
		try {
			GetCardInformationResponse cardInfo = cardClient.getInformation(card);
			result.setCard(cardInfo.getCardNumber());
			result.setProfile(cardInfo.getProfile());
			result.setProfileCode(cardInfo.getProfileCode());
			result.setBankCode(cardInfo.getBankCode());
			result.setProfile_es(cardInfo.getProfile_es());
			result.setBankCode(cardInfo.getBankCode());
			result.setBankName(cardInfo.getBankName());
			result.setUserName(cardInfo.getUserName());
			result.setUserLastName(cardInfo.getUserLastName());
		} catch (FeignException e) {
			this.logger.error("Error on communication: " + e);
		}

		try {
			GetCardBalanceResponse cardBalance = cardClient.getBalance(card);
			result.setBalance(cardBalance.getBalance());
			result.setBalanceDate(cardBalance.getBalanceDate());
			result.setCard(cardBalance.getCard());
			result.setVirtualBalanceDate(cardBalance.getVirtualBalanceDate());
			result.setVirtualBalance(cardBalance.getVirtualBalance());
		} catch (FeignException e) {
			this.logger.error("Error on communication: " + e);
		}

		LogInformation model = new LogInformation();
		model.setCard(card);
		model.setClientIp(MDC.get("ClientIp"));
		logInformationdao.save(model);

		return result;
	}

}
