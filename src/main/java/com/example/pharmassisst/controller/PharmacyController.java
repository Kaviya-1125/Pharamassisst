package com.example.pharmassisst.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pharmassisst.requestdtos.PharmacyRequest;
import com.example.pharmassisst.responsedtos.PharmacyResponse;
import com.example.pharmassisst.service.PharmacyService;
import com.example.pharmassisst.utility.AppResponseBuilder;
import com.example.pharmassisst.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class PharmacyController {
	
	private final PharmacyService pharmacyService;
	private final AppResponseBuilder responseBuilder;
	
	public PharmacyController(PharmacyService pharmacyService, AppResponseBuilder responseBuilder) {
		super();
		this.pharmacyService = pharmacyService;
		this.responseBuilder = responseBuilder;
	}
	
	@PostMapping("/admins/{adminId}/pharmacies")
	public ResponseEntity<ResponseStructure<PharmacyResponse>> addPharmacy(@RequestBody @Valid PharmacyRequest pharmacyRequest, @PathVariable String adminId) {
	
		PharmacyResponse response = pharmacyService.addPharmacy(pharmacyRequest,adminId);
		return responseBuilder.success(HttpStatus.CREATED, "Pharmacy Created", response);
	}

}
