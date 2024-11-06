package com.example.pharmassisst.service;

import org.springframework.stereotype.Service;

import com.example.pharmassisst.entity.Pharmacy;
import com.example.pharmassisst.exception.AdminNotFoundByIdException;
import com.example.pharmassisst.mapper.PharmacyMapper;
import com.example.pharmassisst.repository.AdminRepository;
import com.example.pharmassisst.repository.PharmacyRepository;
import com.example.pharmassisst.requestdtos.PharmacyRequest;
import com.example.pharmassisst.responsedtos.PharmacyResponse;

import jakarta.validation.Valid;

@Service
public class PharmacyService {

	private final PharmacyRepository pharmacyRepository;
	private final PharmacyMapper pharmacyMapper;
	private final AdminRepository adminRepository;

	public PharmacyService(PharmacyRepository pharmacyRepository, PharmacyMapper pharmacyMapper,AdminRepository adminRepository) {
		super();
		this.pharmacyRepository = pharmacyRepository;
		this.pharmacyMapper = pharmacyMapper;
		this.adminRepository = adminRepository;
	}

	public PharmacyResponse addPharmacy(@Valid PharmacyRequest pharmacyRequest, String adminId) {


		return adminRepository.findById(adminId)
				.map( admin -> {
					Pharmacy pharmacy = pharmacyRepository
							.save(pharmacyMapper.mapToPharmacy(pharmacyRequest, new Pharmacy()));
					admin.setPharmacy(pharmacy);
					adminRepository.save(admin);
					return pharmacyMapper.mapToPharmacyResponse(pharmacy);				
				})
				.orElseThrow(() ->new AdminNotFoundByIdException("Failed to find Admin"));
	}

}


