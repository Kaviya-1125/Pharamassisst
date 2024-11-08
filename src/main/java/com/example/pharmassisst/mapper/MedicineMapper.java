package com.example.pharmassisst.mapper;

import org.springframework.stereotype.Component;

import com.example.pharmassisst.entity.Medicine;
import com.example.pharmassisst.requestdtos.MedicineRequest;
import com.example.pharmassisst.responsedtos.MedicineResponse;
@Component
public class MedicineMapper {
	
	public Medicine mapToMedicine(MedicineRequest medicineRequest, Medicine medicine) {
		medicine.setName(medicineRequest.getName());
		medicine.setCategory(medicineRequest.getCategory());
		medicine.setDosageInMg(medicineRequest.getDosageInMg());
		medicine.setExpiryDate(medicineRequest.getExpiryDate());
		medicine.setForm(medicineRequest.getForm());
		medicine.setIngredients(medicineRequest.getIngredients());
		medicine.setManufacturer(medicineRequest.getManufacturer());
		medicine.setPrice(medicineRequest.getPrice());
		medicine.setStockQuantity(medicineRequest.getStockQuantity());

		return medicine;
	}

	public MedicineResponse mapToMedicineResponse(Medicine medicine) {

		MedicineResponse response = new MedicineResponse();

		response.setMedicineId(medicine.getMedicineId());
		response.setName(medicine.getName());
		response.setCategory(medicine.getCategory());
		response.setForm(medicine.getForm());
		response.setDosageInMg(medicine.getDosageInMg());
		response.setIngredients(medicine.getIngredients());
		response.setManufacturer(medicine.getManufacturer());
		response.setPrice(medicine.getPrice());
		response.setStockQuantity(medicine.getStockQuantity());
		response.setExpiryDate(medicine.getExpiryDate());

		return response;
	}

}
