package com.example.pharmassisst.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pharmassisst.entity.Patient;
import com.example.pharmassisst.exception.NoPatientsFoundException;
import com.example.pharmassisst.exception.PatientNotFoundByIdException;
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


	public List<PatientResponse> findAllPatientByPharmacyId(String pharmacyId) {
		return pharmacyRepository.findById(pharmacyId)
				.map(pharmacy -> patientRepository.findByPharmacy(pharmacy))
				.filter(patients -> !patients.isEmpty())
				.orElseThrow(() -> new NoPatientsFoundException("Failed to find patients associated with the pharmacyID: " + pharmacyId))
				.stream()
				.map(patientMapper::mapToPatientResponse)
				.toList();
	}


	public PatientResponse updatePatient(PatientRequest patientRequest, String patientId) {

		return 	patientRepository.findById(patientId)
				.map(exPatient -> {
					patientMapper.mapToPatient(patientRequest, exPatient);
					return patientRepository.save(exPatient);
				})
				.map(patientMapper::mapToPatientResponse)
				.orElseThrow(() -> new PatientNotFoundByIdException("Failed to update Patient"));

	}
}
