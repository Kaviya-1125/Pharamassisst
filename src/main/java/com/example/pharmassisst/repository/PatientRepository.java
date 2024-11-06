package com.example.pharmassisst.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pharmassisst.entity.Patient;
import com.example.pharmassisst.entity.Pharmacy;

public interface PatientRepository extends JpaRepository<Patient, String> {
	
	List<Patient> findByPharmacy(Pharmacy pharmacy);

}
