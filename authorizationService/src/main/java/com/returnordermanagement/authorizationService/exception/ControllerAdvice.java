package com.returnordermanagement.authorizationService.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

@RestControllerAdvice
public class ControllerAdvice {
	@ExceptionHandler(UsernameNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error userNotFoundException(UsernameNotFoundException userNotFoundException) {
		return new Error(HttpStatus.NOT_FOUND, LocalDateTime.now(), userNotFoundException.getMessage());
	}

	@ExceptionHandler(MalformedJwtException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public Error tokenMalformedException() {
		return new Error(HttpStatus.UNAUTHORIZED, LocalDateTime.now(), "Not Authorized --> Token is Invalid..");
	}

	@ExceptionHandler(SignatureException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public Error tokenSignatureException() {
		return new Error(HttpStatus.UNAUTHORIZED, LocalDateTime.now(), "Not Authorized --> Token is Invalid..");
	}
}
