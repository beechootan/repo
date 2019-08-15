package com.example.clinic.controllers;

import com.example.clinic.entities.DoctorStatus;
import com.example.clinic.repositories.DoctorStatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    long id = 4;
    return doctorStatusRepository.findById(id).orElse(new DoctorStatus());
  }

  @PostMapping(value = "/doctorStatus/{status}")
  public void updateDoctorStatus(@PathVariable("status") Boolean status) {
    long id = 1;
    DoctorStatus existingDoctorStatus = doctorStatusRepository.findById(id).orElse(new DoctorStatus());
    if (existingDoctorStatus.getId() != null) {
      existingDoctorStatus.setId(id);
      existingDoctorStatus.setStatus(status);
      doctorStatusRepository.save(existingDoctorStatus);
    }
    ;
  }

}