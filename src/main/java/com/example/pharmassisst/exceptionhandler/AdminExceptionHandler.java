package com.example.pharmassisst.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.pharmassisst.exception.NoAdminsFoundException;
import com.example.pharmassisst.utility.AppResponseBuilder;
import com.example.pharmassisst.utility.ErrorStructure;

@RestControllerAdvice
public class AdminExceptionHandler {

	private final AppResponseBuilder responseBuilder;

	public AdminExceptionHandler(AppResponseBuilder responseBuilder) {
		super();
		this.responseBuilder = responseBuilder;
	}

	@ExceptionHandler(NoAdminsFoundException.class)
	public ResponseEntity<ErrorStructure> handleNoAdminsFound(NoAdminsFoundException ex) {

		return responseBuilder.error(HttpStatus.NOT_FOUND,ex.getMessage(),"No admins found based on the criteria");
	}

}
