package com.example.pharmassisst.exception;

public class PatientNotFoundByIdException extends RuntimeException {
	private final String message;



	public PatientNotFoundByIdException(String message) {
		super();
		this.message = message;
	}



	public String getMessage() {
		return message;
	}

}
