package com.example.pharmassisst.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pharmassisst.requestdtos.AdminRequest;
import com.example.pharmassisst.responsedtos.AdminResponse;
import com.example.pharmassisst.service.AdminService;
import com.example.pharmassisst.utility.AppResponseBuilder;
import com.example.pharmassisst.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class AdminController {
	
	private final AdminService adminService;
	private final AppResponseBuilder responseBuilder;
	
	public AdminController(AdminService adminService, AppResponseBuilder responseBuilder) {
		super();
		this.adminService = adminService;
		this.responseBuilder = responseBuilder;
	}
	
	@PostMapping("/admins")
	public ResponseEntity<ResponseStructure<AdminResponse>> saveAdmin(@RequestBody @Valid AdminRequest adminRequest) {
	
		AdminResponse response =  adminService.saveAdmin(adminRequest);
		return responseBuilder.success(HttpStatus.CREATED, "Admin Created",response);
	}
	
	@GetMapping("/admins/{adminId}")
	public ResponseEntity<ResponseStructure<AdminResponse>> findAdmin(@PathVariable String adminId) {
		
		AdminResponse response = adminService.findAdmin(adminId);
		return responseBuilder.success(HttpStatus.FOUND,"Admin Found", response);
	}
	
	@PutMapping("/admins/{adminId}")
	public ResponseEntity<ResponseStructure<AdminResponse>> updateAdmin(@RequestBody AdminRequest adminRequest,@PathVariable String adminId) {
		
		AdminResponse response = adminService.updateAdmin(adminRequest, adminId);
		return responseBuilder.success(HttpStatus.OK,"Admin updated", response);
	}

}
