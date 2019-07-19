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
    return appointmentRepository.findAll();
  }

  @GetMapping(value = "/appointments/currentQueue", produces = "application/json")
  public Integer displayCurrentAppointments() {
    // Integer currentQueue =
    // appointmentRepository.findCurrentQueue().getQueueNum();
    // if (currentQueue != null) {
    // return currentQueue;
    // } else {
    // return 0;
    // }
    return 0;

  }

  @PostMapping(value = "/appointments/{employeeName}")
  public void updateAppointment(@RequestBody Appointment appointment,
      @PathVariable("employeeName") String employeeName) {
    // Integer employeeId =
    // employeeRepository.findByEmployeeName(employeeName).getEmployeeId();
    // appointment.setEmployeeId(employeeId);

    Appointment latestAppointment = appointmentRepository.findAll().get(0);
    if (latestAppointment != null) {
      Integer maxQueue = latestAppointment.getQueueNum();
      System.out.println("========================");
      System.out.println(maxQueue);
    }

    // if (maxQueue != null) {
    // appointment.setQueueNum(maxQueue + 1);
    // } else {
    // appointment.setQueueNum(1);
    // }

    appointmentRepository.save(appointment);
  }

}