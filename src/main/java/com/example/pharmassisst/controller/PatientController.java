package com.example.pharmassisst.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pharmassisst.requestdtos.PatientRequest;
import com.example.pharmassisst.responsedtos.PatientResponse;
import com.example.pharmassisst.service.PatientService;
import com.example.pharmassisst.utility.AppResponseBuilder;
import com.example.pharmassisst.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class PatientController {
	
	private final PatientService patientService;
	private final AppResponseBuilder responseBuilder;
	
	public PatientController(PatientService patientService, AppResponseBuilder responseBuilder) {
		super();
		this.patientService = patientService;
		this.responseBuilder = responseBuilder;
	}
	
	@PostMapping("/pharmacies/{pharmacyId}/patients")
	public ResponseEntity<ResponseStructure<PatientResponse>> addPatient(@RequestBody @Valid PatientRequest patientRequest, @PathVariable String pharmacyId) {
		 PatientResponse response = patientService.addPatient(patientRequest,pharmacyId);
		 return responseBuilder.success(HttpStatus.CREATED,"Patient registered",response);
	}	
	

}
