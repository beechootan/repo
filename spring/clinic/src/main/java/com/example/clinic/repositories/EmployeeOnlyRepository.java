package com.example.clinic.repositories;

import com.example.clinic.entities.EmployeeOnly;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * EmployeeOnlyRepository
 */
public interface EmployeeOnlyRepository extends JpaRepository<EmployeeOnly, Long> {
  EmployeeOnly findByEmployeeName(String employeeName);

}