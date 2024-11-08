package com.example.pharmassisst.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pharmassisst.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, String> {

}
