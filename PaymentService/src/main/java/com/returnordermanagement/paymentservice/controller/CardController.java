package com.returnordermanagement.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.returnordermanagement.paymentservice.service.CardService;

@RestController
public class CardController {
	@Autowired
	private CardService cardService;


	@GetMapping("/card/{cardNumber}/{charge}")
	@ResponseStatus(code = HttpStatus.OK)
	public double getBalance(@PathVariable long cardNumber, @PathVariable double charge) {

		return cardService.processPayment(cardNumber, charge);

	}
	
	@GetMapping("/card/{requestId}/{cardNumber}/{charge}")
	@ResponseStatus(code = HttpStatus.OK)
	public double getCBalance(@PathVariable("cardNumber") long cardNumber, @PathVariable("charge") double charge) {
		return cardService.processReversePayment(cardNumber, charge);
	}
}
