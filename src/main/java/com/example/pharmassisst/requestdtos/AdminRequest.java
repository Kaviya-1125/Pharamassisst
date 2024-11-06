package com.example.pharmassisst.requestdtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AdminRequest {
	
	@NotNull(message="email cannot be null")
	@NotBlank(message = "email cannot be blank")
	private String adminEmail;
	
	@NotNull(message="password cannot be null")
	@NotBlank(message = "password cannot be blank")
	private String adminPassword;
	
	@NotNull(message="MobileNumber cannot be null")
	@NotBlank(message = "MobileNumber cannot be blank")
	@Pattern(regexp = "^(?:\\+91|91|0)?[789]\\d{9}$", message = "Invalid Mobile number")
	private String adminPhoneNumber;

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminPhoneNumber() {
		return adminPhoneNumber;
	}

	public void setAdminPhoneNumber(String adminPhoneNumber) {
		this.adminPhoneNumber = adminPhoneNumber;
	}

}
