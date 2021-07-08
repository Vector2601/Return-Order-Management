package com.returnordermanagement.packaginganddelivery.exception;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.returnordermanagement.packaginganddelivery.model.ErrorResponse;

import lombok.extern.slf4j.Slf4j;



@RestControllerAdvice
@Slf4j


public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	ErrorResponse errorResponse;

	
	@Autowired
	private Environment env;

	
	@ExceptionHandler(TokenInvalidException.class)
	public ResponseEntity<ErrorResponse> invalidToken(TokenInvalidException ex) {
		errorResponse.setMessage("Please enter valid Token");
		errorResponse.setStatus(HttpStatus.FORBIDDEN);
		errorResponse.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.FORBIDDEN);
	}

	
	@ExceptionHandler(ComponentTypeNotFound.class)
	public ResponseEntity<ErrorResponse> componentTypeNotFound(ComponentTypeNotFound ex) {

		errorResponse.setMessage("Please enter valid Component Type");
		errorResponse.setReason("You need to provide date Integral or Accessory");
		errorResponse.setStatus(HttpStatus.NOT_FOUND);
		errorResponse.setTimestamp(LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}

}
