package com.example.pharmassisst.mapper;

import org.springframework.stereotype.Component;

import com.example.pharmassisst.entity.Admin;
import com.example.pharmassisst.requestdtos.AdminRequest;
import com.example.pharmassisst.responsedtos.AdminResponse;
@Component
public class AdminMapper {

	public Admin mapToAdmin(AdminRequest adminRequest, Admin admin) {

		admin.setAdminEmail(adminRequest.getAdminEmail());
		admin.setAdminPassword(adminRequest.getAdminPassword());
		admin.setAdminPhoneNumber(adminRequest.getAdminPhoneNumber());

		return admin;
	}

	public AdminResponse mapToAdminResponse(Admin admin) {

		AdminResponse response = new AdminResponse();
		response.setAdminId(admin.getAdminId());
		response.setAdminEmail(admin.getAdminEmail());

		return response;
	}

}
