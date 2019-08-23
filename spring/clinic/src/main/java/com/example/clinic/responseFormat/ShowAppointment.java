package com.example.clinic.responseFormat;

import com.example.clinic.entities.Appointment;
import com.example.clinic.entities.Employee;

/**
 * ShowAppointment
 */
public class ShowAppointment {
  public Appointment appointment;
  public Employee employee;

  public ShowAppointment(Appointment appointment, Employee employee) {
    this.appointment = appointment;
    this.employee = employee;
  }

  public Appointment getAppointment() {
    return this.appointment;
  }

  public void setAppointment(Appointment appointment) {
    this.appointment = appointment;
  }

  public Employee getEmployee() {
    return this.employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }
}