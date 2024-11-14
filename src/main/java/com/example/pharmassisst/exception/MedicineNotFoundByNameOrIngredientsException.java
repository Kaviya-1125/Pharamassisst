package com.example.pharmassisst.exception;

public class MedicineNotFoundByNameOrIngredientsException extends RuntimeException {
	
	private final String message;

	

	public MedicineNotFoundByNameOrIngredientsException(String message) {
		super();
		this.message = message;
	}



	public String getMessage() {
		return message;
	}

}
