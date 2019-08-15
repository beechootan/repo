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
<<<<<<< HEAD
  public DoctorStatus findById() {
    long id = 4;
    return doctorStatusRepository.findById(id).orElse(new DoctorStatus());
=======
  public String findByTop() {
    // long id = 1;
    String status = "Not available";
    if (doctorStatusRepository.findByTop().getStatus()) {
      status = "Available";
    }
    return status;
>>>>>>> 33bf770a7d964e5b22e977ad0309fa8ae007c24e
  }

  @PostMapping(value = "/doctorStatus/{status}")
  public void updateDoctorStatus(@PathVariable("status") Boolean status) {
    DoctorStatus existingDoctorStatus = doctorStatusRepository.findByTop();
    if (existingDoctorStatus.getId() != null) {
      // existingDoctorStatus.setId(id);
      existingDoctorStatus.setStatus(status);
      doctorStatusRepository.save(existingDoctorStatus);
    }
    
  }

}

  
  