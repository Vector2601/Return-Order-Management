package com.returnordermanagement.returnorderportal.client;
import java.time.LocalDate;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.returnordermanagement.returnorderportal.model.ProcessRequest;
import com.returnordermanagement.returnorderportal.model.ProcessResponse;

@FeignClient
(name="component-processing", url="${component-processing-service-url}")
public interface ComponentProcessingFeignClient {

	@PostMapping("/service")
	ProcessResponse getProcessingDetails(@RequestHeader("Authorization") String token,
            @RequestBody ProcessRequest processRequest);
	
	@GetMapping("/payment/{requestId}/{creditCardNumber}/{creditLimit}/{processingCharge}")
	public String paymentProcessing(@RequestHeader("Authorization") String token,
			@PathVariable("requestId") int requestId, @PathVariable("creditCardNumber") long creditCardNumber,
			@PathVariable("creditLimit") double creditLimit, @PathVariable("processingCharge") double processingcharge);
	
	@GetMapping("/reversePayment/{requestId}/{creditCardNumber}")
	public String reversePaymentProcessing(@RequestHeader("Authorization") String token,
			@PathVariable("requestId") int requestId, @PathVariable("creditCardNumber") long creditCardNumber);
	
	@GetMapping("/track/{id}")
	public LocalDate trackRequest(@PathVariable("id") int id);
	
	@GetMapping("/deleteRequest/{id}")
	public String deleteRequest(@PathVariable("id") int id);
}
