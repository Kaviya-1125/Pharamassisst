package com.example.pharmassisst.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.pharmassisst.entity.Admin;
import com.example.pharmassisst.exception.AdminNotFoundByIdException;
import com.example.pharmassisst.mapper.AdminMapper;
import com.example.pharmassisst.repository.AdminRepository;
import com.example.pharmassisst.requestdtos.AdminRequest;
import com.example.pharmassisst.responsedtos.AdminResponse;

import jakarta.validation.Valid;
@Service
public class AdminService {


	private final AdminRepository adminRepository;
	private final AdminMapper adminMapper;
	private final PasswordEncoder passwordEncoder;

	public AdminService(AdminRepository adminRepository, AdminMapper adminMapper, PasswordEncoder passwordEncoder) {
		super();
		this.adminRepository = adminRepository;
		this.adminMapper = adminMapper;
		this.passwordEncoder=passwordEncoder;
	}

	public AdminResponse saveAdmin(@Valid AdminRequest adminRequest) {
		
		Admin admin = adminMapper.mapToAdmin(adminRequest, new Admin());
		
		admin.setAdminPassword(passwordEncoder.encode(admin.getAdminPassword()));
		
		Admin admin1 = adminRepository.save(admin);
		
		return adminMapper.mapToAdminResponse(admin1);


	}

	public AdminResponse findAdmin(String adminId) {
		  return  adminRepository.findById(adminId)
                  .map(adminMapper::mapToAdminResponse)
                  .orElseThrow(() -> new AdminNotFoundByIdException("Failed to find admin"));
	}

	public AdminResponse updateAdmin(AdminRequest adminRequest, String adminId) {
		
		return adminRepository.findById(adminId)
                .map(exAdmin -> {
       	          adminMapper.mapToAdmin(adminRequest, exAdmin);
       	          return adminRepository.save(exAdmin);
                })
                .map(adminMapper::mapToAdminResponse)
                .orElseThrow(() -> new AdminNotFoundByIdException("Failed to update admin"));
	}

}
