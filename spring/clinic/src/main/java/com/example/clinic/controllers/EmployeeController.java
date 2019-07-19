package com.example.clinic.controllers;

import com.example.clinic.entities.Employee;
import com.example.clinic.repositories.EmployeeRepository;
import com.example.clinic.repositories.AppointmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping(value = "/appointments/{name}", produces = "application/json")
  public Employee findAppointment(@PathVariable String name) {
    return employeeRepository.findByEmployeeName(name);
  }

}