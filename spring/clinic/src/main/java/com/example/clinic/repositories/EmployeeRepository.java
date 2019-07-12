package com.example.clinic.repositories;

import com.example.clinic.entities.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}