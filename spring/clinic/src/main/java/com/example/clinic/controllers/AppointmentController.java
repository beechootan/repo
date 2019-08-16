package com.example.clinic.controllers;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

import com.example.clinic.entities.AllAppointment;
import com.example.clinic.entities.Employee;
import com.example.clinic.repositories.AppointmentRepository;
import com.example.clinic.repositories.AllAppointmentRepository;
import com.example.clinic.repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
  AllAppointmentRepository allAppointmentRepository;

  @Autowired
  EmployeeRepository employeeRepository;

  @GetMapping(value = "/appointments", produces = "application/json")
  public List<AllAppointment> displayAppointments() {
    // return allAppointmentRepository.findAllByIsToday(true);
    return allAppointmentRepository.findByIsToday();

  }

  @GetMapping(value = "/appointments/{name}/today", produces = "application/json")
  public Integer findTodayAppointmentByEmployee(@PathVariable String name) {
    Integer appointmentToday = 0;
    if (appointmentRepository.findCurrentAppointmentByEmployeeName(name) != null) {
      appointmentToday = appointmentRepository.findCurrentAppointmentByEmployeeName(name).getQueueNum();
    }
    return appointmentToday;
  }

  @GetMapping(value = "/appointments/currentQueue", produces = "application/json")
  public Integer displayCurrentAppointments() {
    Integer currentQueue = 0;
    if (appointmentRepository.findByStatus("In Progress") != null) {
      currentQueue = appointmentRepository.findByStatus("In Progress").getQueueNum();
    } else {
      currentQueue = appointmentRepository.findCompleted().getQueueNum();
    }
    return currentQueue;
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

  @PostMapping(value = "/appointments/{employeeName}/addAppointment")
  public String addAppointment(@PathVariable("employeeName") String employeeName) {
    String message = "";
    Employee employee = employeeRepository.findByEmployeeName(employeeName);
    AllAppointment latestAppointment = allAppointmentRepository.findCurrentAppointmentById(employee.getId());
    Integer maxQueue = displayTotalAppointments();
    if (maxQueue != null) {
      maxQueue = maxQueue + 1;
    } else {
      maxQueue = 1;
    }
    ;
    if (appointmentRepository.findCurrentAppointmentByEmployeeName(employeeName) != null) {
      message = " XX ";
    } else {
      AllAppointment newAppointment = new AllAppointment();
      newAppointment.setQueueNum(maxQueue);
      newAppointment.setEmployeeId(employee.getId());
      // newAppointment.setSymptom("");
      newAppointment.setStatus("Open");
      newAppointment.setIsToday(true);
      newAppointment.setLastUpdBy(employee.getId());
      allAppointmentRepository.save(newAppointment);
      message = "Appointment made. ";
    }
    ;
    message = message + "Your queue number is " + latestAppointment.getQueueNum();
    return message;
  }

  // @PostMapping(value = "/appointments/{nurseId}/{appointmentId}/{type}")
  // public void updateTime(@PathVariable("nurseId") Long nurseId,
  // @PathVariable("appointmentId") Long id,
  // @PathVariable("type") String type) {
  // AllAppointment updateAppointment = allAppointmentRepository.findById(id);
  // LocalDateTime now = LocalDateTime.now();
  // updateAppointment.setLastUpdBy(nurseId);
  // if (type == "checkIn") {
  // updateAppointment.setCheckInTime(now);
  // updateAppointment.setStatus("In Progress");

  // }
  // ;

  // if (type == "checkOut") {
  // updateAppointment.setCheckOutTime(now);
  // updateAppointment.setStatus("Completed");
  // }
  // ;

  // allAppointmentRepository.save(updateAppointment);

  // }

  // @PostMapping(value = "/appointments/cancel/{employeeId}/{appointmentId}")
  // public void updateCancelStatus(@PathVariable("employeeId") Long employeeId,
  // @PathVariable("appointmentId") Long id) {
  // AllAppointment updateCancelAppointment =
  // allAppointmentRepository.findById(id);

  // updateCancelAppointment.setLastUpdBy(employeeId);
  // updateCancelAppointment.setStatus("Cancel");

  // allAppointmentRepository.save(updateCancelAppointment);

  // }

  @PostMapping(value = "/appointments/closeQueue")
  public void updateCloseQueue() {
    List<AllAppointment> closeQueues = allAppointmentRepository.findByIsToday();
    AllAppointment closeQueue;
    for (int i = 0; i < closeQueues.size(); i++) {
      closeQueue = closeQueues.get(i);
      closeQueue.setIsToday(false);
      // String status = closeQueue.getStatus();
      // if (status == "Open") {
      // closeQueue.setStatus("Cancel");
      // }
      // if (status == "In Progress") {
      // closeQueue.setStatus("Cancel");
      // }

      allAppointmentRepository.save(closeQueue);
    }

  }

}