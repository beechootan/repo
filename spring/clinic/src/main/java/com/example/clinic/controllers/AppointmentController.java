package com.example.clinic.controllers;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import com.example.clinic.entities.Appointment;
import com.example.clinic.entities.Employee;
import com.example.clinic.repositories.AppointmentRepository;
import com.example.clinic.repositories.EmployeeRepository;
import com.example.clinic.responseFormat.ShowAppointment;

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

  // @Autowired
  // AllAppointmentRepository allAppointmentRepository;

  @Autowired
  EmployeeRepository employeeRepository;

  // @Autowired
  // EmployeeOnlyRepository employeeOnlyRepository;

  @GetMapping(value = "/appointments", produces = "application/json")
  public List<ShowAppointment> displayAppointment() {
    // return allAppointmentRepository.findAllByIsToday(true);
    // return allAppointmentRepository.findByIsToday();

    List<Appointment> appointments = appointmentRepository.findAllByIsToday();
    List<ShowAppointment> result = new ArrayList<ShowAppointment>();
    for (Appointment appointment : appointments) {

      Employee employee = employeeRepository.findById(appointment.getEmployeeId()).orElse(null);
      if (employee != null) {
        result.add(new ShowAppointment(appointment, employee));
      }
    }

    return result;

  }

  // @GetMapping(value = "/appointments/{name}/today", produces =
  // "application/json")
  // public Integer findTodayAppointmentByEmployee(@PathVariable ("name") String
  // name) {
  // Integer appointmentTodayByName = 0;
  // if (appointmentRepository.findCurrentAppointmentByEmployeeName(name) != null)
  // {
  // appointmentTodayByName =
  // appointmentRepository.findCurrentAppointmentByEmployeeName(name).getQueueNum();
  // }
  // return appointmentTodayByName;
  // }

  @GetMapping(value = "/appointments/{employeeId}/today", produces = "application/json")
  public Integer findTodayAppointmentByEmployeeId(@PathVariable("employeeId") Long id) {
    Integer appointmentTodayById = 0;
    if (appointmentRepository.findCurrentAppointmentById(id) != null) {
      appointmentTodayById = appointmentRepository.findCurrentAppointmentById(id).getQueueNum();
    }
    return appointmentTodayById;
  }

  @GetMapping(value = "/appointments/currentQueue", produces = "application/json")
  public Integer displayCurrentAppointments() {
    Integer currentQueue = 0;
    if (appointmentRepository.findByStatus("In Progress") != null) {
      currentQueue = appointmentRepository.findByStatus("In Progress").getQueueNum();
    } else {
      if (appointmentRepository.findCompleted() != null) {
        currentQueue = appointmentRepository.findCompleted().getQueueNum();
      } else {
        appointmentRepository.findByMaxCompleted().getQueueNum();
      }
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

  // @PostMapping(value = "/appointments/{employeeId}/addAppointment")
  // public String addAppointment(@PathVariable("employeeId") Long id) {
  // String message = "";
  // Employee employee = employeeRepository.findById(id).orElse(null);
  // Appointment latestAppointment =
  // appointmentRepository.findCurrentAppointmentById(employee.getId());
  // Integer maxQueue = displayTotalAppointments();
  // if (maxQueue != null) {
  // maxQueue = maxQueue + 1;
  // } else {
  // maxQueue = 1;
  // }
  // ;
  // if (appointmentRepository.findCurrentAppointmentById(id) != null) {
  // message = " XX ";
  // } else {
  // Appointment newAppointment = new Appointment();
  // newAppointment.setQueueNum(maxQueue);
  // newAppointment.setEmployeeId(employee.getId());
  // // newAppointment.setSymptom("");
  // newAppointment.setStatus("Open");
  // newAppointment.setIsToday(true);
  // newAppointment.setLastUpdBy(employee.getBadgeNumber());
  // appointmentRepository.save(newAppointment);
  // message = "Appointment made. ";
  // latestAppointment = newAppointment;
  // }
  // ;
  // message = message + "Your queue number is " +
  // latestAppointment.getQueueNum();
  // return message;
  // }

  // @PostMapping(value = "/appointments/{employeeId}/{patientId}/addAppointment")
  // public String addAppointment(@PathVariable("employeeId") Long id,
  // @PathVariable("patientId") Long patientId) {
  // String message = "";
  // Employee employee = employeeRepository.findById(id).orElse(null);
  // Employee patient = employeeRepository.findById(patientId).orElse(null);
  // Appointment latestAppointment =
  // appointmentRepository.findCurrentAppointmentById(patient.getId());
  // Integer maxQueue = displayTotalAppointments();
  // if (maxQueue != null) {
  // maxQueue = maxQueue + 1;
  // } else {
  // maxQueue = 1;
  // }
  // ;

  // if (latestAppointment != null) {
  // message = "Your queue number is " + latestAppointment.getQueueNum();
  // } else {
  // if (employee != null) {
  // if (employee.getIsNurse() || (employee.getId().equals(patient.getId()))) {
  // Appointment newAppointment = new Appointment();
  // newAppointment.setQueueNum(maxQueue);
  // newAppointment.setEmployeeId(patient.getId());
  // // newAppointment.setSymptom("");
  // newAppointment.setStatus("Open");
  // newAppointment.setIsToday(true);
  // newAppointment.setLastUpdBy(employee.getBadgeNumber());
  // appointmentRepository.save(newAppointment);
  // latestAppointment = newAppointment;
  // message = "Appointment made. Your queue number is " +
  // latestAppointment.getQueueNum();
  // } else {
  // message = "Only nurse has the rights to make appointment for other. Kindly
  // contact clinic. ";
  // }
  // ;

  // } else {
  // message = "Not able to locate your employee ID. Please relogin.";
  // }
  // ;
  // }

  // ;

  // return message;
  // }

  @PostMapping(value = "/appointments/addAppointment")
  public String addAppointment(@RequestBody Appointment appointment) {
    String message = "";
    Appointment latestAppointment = new Appointment();
    Employee employee = employeeRepository.findById(appointment.getLastUpdBy()).orElse(null);
    Employee patient = employeeRepository.findById(appointment.getEmployeeId()).orElse(null);
    if (patient != null) {
      latestAppointment = appointmentRepository.findCurrentAppointmentById(patient.getId());
    } else {
      latestAppointment = null;
    }
    ;
    Integer maxQueue = displayTotalAppointments();
    if (maxQueue != null) {
      maxQueue = maxQueue + 1;
    } else {
      maxQueue = 1;
    }
    ;
    System.out.println("");
    if (latestAppointment != null) {
      message = "Your queue number is " + latestAppointment.getQueueNum();
    } else {
      if (patient != null) {
        if (employee.getIsNurse() || (employee.getId().equals(patient.getId()))) {
          Appointment newAppointment = new Appointment();
          newAppointment.setQueueNum(maxQueue);
          newAppointment.setEmployeeId(patient.getId());
          // newAppointment.setSymptom("");
          newAppointment.setStatus("Open");
          newAppointment.setIsToday(true);
          newAppointment.setLastUpdBy(employee.getId());
          appointmentRepository.save(newAppointment);
          latestAppointment = newAppointment;
          message = "Appointment made. Your queue number is " + latestAppointment.getQueueNum();
        } else {
          message = "Only nurse has the rights to make appointment for other. Kindly contact clinic. ";
        }
      } else {
        message = "Not able to locate your employee ID. Please relogin.";
      }
    }

    ;

    return message;
  }

  @PostMapping(value = "/appointments/{nurseId}/{appointmentId}/{type}")
  public void updateTime(@PathVariable("nurseId") Long nurseId, @PathVariable("appointmentId") Long id,
      @PathVariable("type") String type) {
    Appointment updateAppointment = appointmentRepository.findById(id).orElse(null);
    Employee nurse = employeeRepository.findById(nurseId).orElse(null);
    LocalDateTime now = LocalDateTime.now();

    if (updateAppointment != null) {
      if (nurse != null) {
        updateAppointment.setLastUpdBy(nurse.getId());
      }

      if (type.equals("checkIn")) {
        updateAppointment.setCheckInTime(now);
        updateAppointment.setStatus("In Progress");

      }
      ;

      if (type.equals("checkOut")) {
        updateAppointment.setCheckOutTime(now);
        updateAppointment.setStatus("Completed");
      }
      ;
    }

    appointmentRepository.save(updateAppointment);

  }

  // @PostMapping(value = "/appointments/cancel/{employeeId}/{appointmentId}")
  // public void updateCancelStatus(@PathVariable("employeeId") Long employeeId,
  // @PathVariable("appointmentId") Long id) {
  // Appointment updateCancelAppointment =
  // appointmentRepository.findById(id).orElse(null);
  // Employee nurse = employeeRepository.findById(employeeId).orElse(null);
  // updateCancelAppointment.setLastUpdBy(nurse.getBadgeNumber());
  // updateCancelAppointment.setStatus("Cancel");

  // appointmentRepository.save(updateCancelAppointment);

  // }

  @PostMapping(value = "/appointments/cancel")
  public void updateCancelStatus(@RequestBody Appointment appointment) {
    Appointment updateCancelAppointment = appointmentRepository.findById(appointment.getId()).orElse(null);
    Employee nurse = employeeRepository.findById(appointment.getLastUpdBy()).orElse(null);
    updateCancelAppointment.setLastUpdBy(nurse.getId());
    updateCancelAppointment.setStatus("Cancel");
    if (updateCancelAppointment != null) {
      if (nurse.getIsNurse() || updateCancelAppointment.getEmployeeId().equals(appointment.getLastUpdBy())) {
        appointmentRepository.save(updateCancelAppointment);
      }
    }
  }

  @PostMapping(value = "/appointments/closeQueue")
  public void updateCloseQueue() {
    List<Appointment> closeQueues = appointmentRepository.findAllByIsToday();
    Appointment closeQueue;
    for (int i = 0; i < closeQueues.size(); i++) {
      closeQueue = closeQueues.get(i);
      closeQueue.setIsToday(false);
      String status = closeQueue.getStatus();

      if (status.equals("In Progress") || status.equals("Open")) {
        closeQueue.setStatus("Cancel");
      }

      appointmentRepository.save(closeQueue);
    }

  }

}