package com.example.pharmassisst.exception;

public class NoPharmacyFoundException extends RuntimeException {
	
	private final String message;

	public NoPharmacyFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
