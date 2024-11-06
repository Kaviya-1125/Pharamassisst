package com.example.pharmassisst.service;

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

	public AdminService(AdminRepository adminRepository, AdminMapper adminMapper) {
		super();
		this.adminRepository = adminRepository;
		this.adminMapper = adminMapper;
	}

	public AdminResponse saveAdmin(@Valid AdminRequest adminRequest) {

		Admin admin = adminRepository.save(adminMapper.mapToAdmin(adminRequest,new Admin()));
		return adminMapper.mapToAdminResponse(admin);
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
