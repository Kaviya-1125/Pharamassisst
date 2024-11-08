package com.example.pharmassisst.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.pharmassisst.responsedtos.MedicineResponse;
import com.example.pharmassisst.service.MedicineService;
import com.example.pharmassisst.utility.AppResponseBuilder;
import com.example.pharmassisst.utility.ResponseStructure;
import com.example.pharmassisst.utility.SimpleResponseStructure;

@RestController
public class MedicineController {


	private final AppResponseBuilder responseBuilder;
	private final MedicineService medicineService;

	public MedicineController(AppResponseBuilder responseBuilder, MedicineService medicineService) {
		super();
		this.responseBuilder = responseBuilder;
		this.medicineService = medicineService;
	}

	@PostMapping("/pharmacies/{pharmacyId}/medicines")
	public ResponseEntity<SimpleResponseStructure> uploadMedicines(@RequestParam("medicine_info") MultipartFile file,@PathVariable String pharmacyId) {
		
		String message = medicineService.uploadMedicines(file, pharmacyId);
		return responseBuilder.success(HttpStatus.CREATED, message);
		
	}
	
	@GetMapping("/medicines")
	public ResponseEntity<ResponseStructure<List<MedicineResponse>>> findMedicineByNameOrIngredients(
			@RequestParam String name){
		
		List<MedicineResponse> responses = medicineService.findMedicineByNameOrIngredients(name);
		return responseBuilder.success(HttpStatus.FOUND, "Medicine found successfully",responses);
		
	}



}
