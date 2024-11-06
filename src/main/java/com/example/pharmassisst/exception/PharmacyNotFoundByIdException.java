package com.example.pharmassisst.exception;

public class PharmacyNotFoundByIdException extends RuntimeException {

	private final String message;

	public PharmacyNotFoundByIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
