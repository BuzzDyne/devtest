package com.ricky.devtest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ricky.devtest.model.Response;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ErrorController {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Response<String>> constraintViolationException(ConstraintViolationException exc) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(Response.<String>builder().errors(exc.getMessage()).build());
	}
}
