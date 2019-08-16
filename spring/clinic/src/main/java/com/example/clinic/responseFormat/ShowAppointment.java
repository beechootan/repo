package com.example.clinic.responseFormat;

import com.example.clinic.entities.AllAppointment;
import com.example.clinic.entities.EmployeeOnly;

/**
 * ShowAppointment
 */
public class ShowAppointment {
  public AllAppointment appointment;
  public EmployeeOnly employee;

  public ShowAppointment(AllAppointment appointment, EmployeeOnly employee) {
    this.appointment = appointment;
    this.employee = employee;
  }

  public AllAppointment getAppointment() {
    return this.appointment;
  }

  public void setAppointment(AllAppointment appointment) {
    this.appointment = appointment;
  }

  public EmployeeOnly getEmployee() {
    return this.employee;
  }

  public void setEmployee(EmployeeOnly employee) {
    this.employee = employee;
  }
}