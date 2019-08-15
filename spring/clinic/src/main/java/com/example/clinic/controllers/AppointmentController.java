package com.example.clinic.controllers;

import java.util.List;

import com.example.clinic.entities.Appointment;
import com.example.clinic.repositories.AppointmentRepository;
import com.example.clinic.repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AppointmentController
 */
@RestController
@RequestMapping(path = "/api")
public class AppointmentController {
  @Autowired
  AppointmentRepository appointmentRepository;

  @Autowired
  EmployeeRepository employeeRepository;

  @GetMapping(value = "/appointments", produces = "application/json")
  public List<Appointment> displayAppointments() {
    // return appointmentRepository.findAllByIsToday(true);
    return appointmentRepository.findAll();
  }

  @GetMapping(value = "/appointments/{name}/today", produces = "application/json")
  public Appointment findTodayAppointmentByEmployee(@PathVariable String name) {
    return appointmentRepository.findCurrentAppointmentByEmployeeName(name);
  }

  @GetMapping(value = "/appointments/currentQueue", produces = "application/json")
  public Integer displayCurrentAppointments() {
    String status = "In Progress";
    return appointmentRepository.findByStatus(status).getQueueNum();
  }

  @GetMapping(value = "/appointments/totalQueue", produces = "application/json")
  public Integer displayTotalAppointments() {
    int totalQueue = 0;
    if (appointmentRepository.findTotalQueue() != null) {
      totalQueue = appointmentRepository.findTotalQueue().getQueueNum();
    }
    ;
    return totalQueue;
  }

  @PostMapping(value = "/appointments/{employeeName}")
  public void addAppointment(@PathVariable("employeeName") String employeeName) {

    Appointment latestAppointment = appointmentRepository.findCurrentAppointmentByEmployeeName(employeeName)
        .orElse(new Appointment());
    Integer maxQueue = displayTotalAppointments();
    if (maxQueue != null) {
      maxQueue = maxQueue + 1;
    } else {
      maxQueue = 1;
    }
    ;
    if (latestAppointment.getQueueNum() == 1) {
      latestAppointment.setQueueNum(maxQueue);
      latestAppointment.setEmployee(employeeRepository.findByEmployeeName(employeeName));
      latestAppointment.setSymptom("");
      latestAppointment.setStatus("Open");
      latestAppointment.setIsToday(true);
      latestAppointment.setLastUpdBy(latestAppointment.getEmployee().getId());
    }
    ;
    appointmentRepository.save(latestAppointment);
  }

}