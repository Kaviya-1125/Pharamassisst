package com.example.pharmassisst.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

}
