package com.example.pharmassisst.responsedtos;

import java.time.LocalDate;

import com.example.pharmassisst.enums.Gender;

public class PatientResponse {
	
	private String patientId;
	private String patientName;
	private String patientEmail;
	private String patientPhoneNumber;
	private Gender patientGender;
	private LocalDate patientDateOfBirth;
	
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientEmail() {
		return patientEmail;
	}
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}
	public String getPatientPhoneNumber() {
		return patientPhoneNumber;
	}
	public void setPatientPhoneNumber(String patientPhoneNumber) {
		this.patientPhoneNumber = patientPhoneNumber;
	}
	public Gender getPatientGender() {
		return patientGender;
	}
	public void setPatientGender(Gender patientGender) {
		this.patientGender = patientGender;
	}
	public LocalDate getPatientDateOfBirth() {
		return patientDateOfBirth;
	}
	public void setPatientDateOfBirth(LocalDate patientDateOfBirth) {
		this.patientDateOfBirth = patientDateOfBirth;
	}
	
	

}
