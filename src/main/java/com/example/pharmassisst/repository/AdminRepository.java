package com.example.pharmassisst.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pharmassisst.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {

}
