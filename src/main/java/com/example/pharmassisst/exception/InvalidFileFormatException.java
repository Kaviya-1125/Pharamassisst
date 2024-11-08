package com.example.pharmassisst.exception;

public class InvalidFileFormatException extends RuntimeException {
	
	private final String message;

	public String getMessage() {
		return message;
	}

	public InvalidFileFormatException(String message) {
		super();
		this.message = message;
	}
	
	

	

}
