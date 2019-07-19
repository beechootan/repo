package com.example.clinic.repositories;

import com.example.clinic.entities.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  @Query("SELECT e FROM Employee e WHERE e.employeeName = ?1 and e.isToday = true ")
  Employee findByEmployeeName(String name);
}