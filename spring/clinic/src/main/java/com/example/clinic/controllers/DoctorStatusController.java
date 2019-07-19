package com.example.clinic.controllers;

import com.example.clinic.entities.DoctorStatus;
import com.example.clinic.repositories.DoctorStatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DoctorStatusController
 */
@RestController
@RequestMapping(path = "/api")
public class DoctorStatusController {
  @Autowired
  DoctorStatusRepository doctorStatusRepository;

  @GetMapping(value = "/doctorStatus", produces = "application/json")
  public DoctorStatus findById() {
    long id = 1;
    return doctorStatusRepository.findById(id).orElse(new DoctorStatus());
  }
}