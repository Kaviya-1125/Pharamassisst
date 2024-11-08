package com.example.pharmassisst.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.pharmassisst.exception.InvalidDataException;
import com.example.pharmassisst.exception.InvalidDateFormatException;
import com.example.pharmassisst.exception.InvalidFileFormatException;
import com.example.pharmassisst.exception.NoMedicineFoundException;
import com.example.pharmassisst.exception.PatientNotFoundByIdException;
import com.example.pharmassisst.service.MedicineService;
import com.example.pharmassisst.utility.AppResponseBuilder;
import com.example.pharmassisst.utility.ErrorStructure;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class MedicineExceptionHandler {

	private final AppResponseBuilder responseBuilder;


	public MedicineExceptionHandler(AppResponseBuilder responseBuilder) {
		super();
		this.responseBuilder = responseBuilder;

	}
	
	@ExceptionHandler(InvalidDateFormatException.class)
	public ResponseEntity<ErrorStructure> handleDateFormat(InvalidDateFormatException ex) {
		
		return responseBuilder.error(HttpStatus.NOT_ACCEPTABLE,ex.getMessage(),"Data Format is invalid");
	}
	
	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<ErrorStructure> handleDate(InvalidDataException ex) {
		
		return responseBuilder.error(HttpStatus.NOT_ACCEPTABLE,ex.getMessage(),"Data Format is invalid");
	}
	
	@ExceptionHandler(InvalidFileFormatException.class)
	public ResponseEntity<ErrorStructure> handleFileFormat(InvalidDateFormatException ex) {
		
		return responseBuilder.error(HttpStatus.NOT_ACCEPTABLE,ex.getMessage(),"File Format is invalid");
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorStructure> handleConstraintViolationException(ConstraintViolationException ex) {
		
		return responseBuilder.error(HttpStatus.BAD_REQUEST, ex.getMessage(), "Invalid Data Format");
		
	}
	
	
	@ExceptionHandler(NoMedicineFoundException.class)
	public ResponseEntity<ErrorStructure> handleMedicineFoundException(NoMedicineFoundException ex) {
		
		return responseBuilder.error(HttpStatus.BAD_REQUEST, ex.getMessage(), "Invalid Data Format");
		
	}
	





}
