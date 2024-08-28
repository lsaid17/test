package com.test.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.test.api.dto.CardAllInformationResponse;
import com.test.api.services.CardService;

@Controller
@CrossOrigin
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	@GetMapping(value="/get/card-information/{card}" )
	public ResponseEntity<CardAllInformationResponse> getCardInformation(@PathVariable String card) {
		CardAllInformationResponse response = this.cardService.getCardInformation(card);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
