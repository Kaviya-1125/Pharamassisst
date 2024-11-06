package com.example.pharmassisst.service;

import org.springframework.stereotype.Service;

import com.example.pharmassisst.entity.Patient;
import com.example.pharmassisst.exception.PharmacyNotFoundByIdException;
import com.example.pharmassisst.mapper.PatientMapper;
import com.example.pharmassisst.repository.PatientRepository;
import com.example.pharmassisst.repository.PharmacyRepository;
import com.example.pharmassisst.requestdtos.PatientRequest;
import com.example.pharmassisst.responsedtos.PatientResponse;

import jakarta.validation.Valid;
@Service
public class PatientService {

	private final PatientRepository patientRepository;
	private final PharmacyRepository pharmacyRepository;
	private final PatientMapper patientMapper;

	public PatientService(PatientRepository patientRepository, PharmacyRepository pharmacyRepository,
			PatientMapper patientMapper) {
		super();
		this.patientRepository = patientRepository;
		this.pharmacyRepository = pharmacyRepository;
		this.patientMapper = patientMapper;
	}


	public PatientResponse addPatient(@Valid PatientRequest patientRequest, String pharmacyId) {

	return pharmacyRepository.findById(pharmacyId)
			.map(pharmacy  ->{
				Patient patient=patientMapper.mapToPatient(patientRequest, new Patient());
					patient.setPharmacy(pharmacy);
					pharmacy.getPatients().add(patient);
					patientRepository.save(patient);
				return patientMapper.mapToPatientResponse(patient);
				})
			.orElseThrow(() ->new PharmacyNotFoundByIdException("Failed to find Pharmacy"));


			}
	}
