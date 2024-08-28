package com.test.api.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetCardBalanceResponse {
	
	private String card;
	private Integer balance;
	private String balanceDate;
	private Integer virtualBalance;
	private String virtualBalanceDate;
}
