package com.example.pharmassisst.requestdtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PharmacyRequest {
	
	@NotNull(message = "Name cannot be null")
	@NotBlank(message = "Name cannot be blank")
	@Pattern(regexp = "^[A-Za-z0-9'\\-\\s]{3,50}$",message = "Invalid name")
	private String name;

	@NotNull(message = "gstNumber cannot be null")
	@NotBlank(message = "gstNumber cannot be blank")
	@Pattern(regexp = "^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[A-Z0-9]{3}$", message = "Invalid GST number")
	private String gstNumber;

	@NotNull(message = "licenseNumber cannot be null")
	@NotBlank(message = "licenseNumber cannot be blank")
	@Pattern(regexp = "^[A-Z]{2,3}-\\d{4,5}$", message = "Invalid Licence number")
	private String licenseNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	

}
