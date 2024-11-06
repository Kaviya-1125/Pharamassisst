package com.example.pharmassisst.mapper;

import org.springframework.stereotype.Component;

import com.example.pharmassisst.entity.Patient;
import com.example.pharmassisst.requestdtos.PatientRequest;
import com.example.pharmassisst.responsedtos.PatientResponse;

@Component
public class PatientMapper {

	public Patient mapToPatient(PatientRequest patientRequest, Patient patient) {

		patient.setPatientName(patientRequest.getPatientName());
		patient.setPatientEmail(patientRequest.getPatientEmail());
		patient.setPatientPhoneNumber(patientRequest.getPatientPhoneNumber());
		patient.setPatientGender(patientRequest.getPatientGender());
		patient.setPatientDateOfBirth(patientRequest.getPatientDateOfBirth());

		return patient;
	}

	public PatientResponse mapToPatientResponse(Patient patient) {

		PatientResponse response = new PatientResponse();

		response.setPatientId(patient.getPatientId());
		response.setPatientName(patient.getPatientName());
		response.setPatientEmail(patient.getPatientEmail());
		response.setPatientGender(patient.getPatientGender());
		response.setPatientPhoneNumber(patient.getPatientPhoneNumber());
		response.setPatientDateOfBirth(patient.getPatientDateOfBirth());

		return response;
	}
}
