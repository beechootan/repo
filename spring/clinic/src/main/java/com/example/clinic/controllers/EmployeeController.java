package com.example.clinic.controllers;

import com.example.clinic.entities.Employee;
import com.example.clinic.repositories.AppointmentRepository;
import com.example.clinic.repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EmployeeController
 */
@RestController
@RequestMapping(path = "/api")
public class EmployeeController {
  @Autowired
  EmployeeRepository employeeRepository;

  @Autowired
  AppointmentRepository appointmentRepository;

  // @GetMapping(value = "/appointments/{id}", produces = "application/json")
  // public Employee findEmployeeAppointment(@PathVariable Long id) {
  // return employeeRepository.findById(id).orElse(null);
  // }

  @GetMapping(value = "/employee/{id}", produces = "application/json")
  public Boolean verifyIsNurse(@PathVariable Long id) {
    Employee employee = employeeRepository.findById(id).orElse(null);
    Boolean isNurse = false;
    if (employee != null) {
      isNurse = employee.getIsNurse();

    }

    return isNurse;
  }

  @GetMapping(value = "/login", produces = "application/json")
  public Long verifyLogin(@RequestBody Employee employee) {
    Long id = 0L;
    Employee check = employeeRepository.findByEmail(employee.getEmail());
    if (check != null) {
      if (check.getPassword().equals(employee.getPassword())) {
        id = check.getId();
      }
    }
    return id;
  }
}