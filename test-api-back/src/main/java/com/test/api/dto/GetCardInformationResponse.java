package com.test.api.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetCardInformationResponse {
	private String cardNumber;
	private String profileCode;
	private String profile;
	private String profile_es;
	private String bankCode;
	private String bankName;
	private String userName;
	private String userLastName;
}
