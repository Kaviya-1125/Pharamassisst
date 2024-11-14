package com.example.pharmassisst.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.pharmassisst.entity.Admin;

public class UserDetailsImpl implements UserDetails {

	private final Admin admin;

	public UserDetailsImpl(Admin admin) {
		super();
		this.admin = admin;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		return admin.getAdminPassword();
	}

	@Override
	public String getUsername() {
		return admin.getAdminEmail();
	}

}
