package com.example.pharmassisst.exception;

public class NoMedicineFoundException extends RuntimeException {
	
	private final String message;

	public NoMedicineFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
	
	

}
