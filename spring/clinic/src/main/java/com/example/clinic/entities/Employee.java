package com.example.clinic.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Id;

/**
 * Employee
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity(name = "employee")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "employeeId")
  private int employeeId;

  @Column(name = "employeeName")
  private String employeeName;

  @Column(name = "isNurse")
  private boolean isNurse;

  @JsonManagedReference
  @OneToMany(mappedBy = "employee")
  private Set<Appointment> appointments;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getEmployeeId() {
    return this.employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public String getEmployeeName() {
    return this.employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public boolean isIsNurse() {
    return this.isNurse;
  }

  public boolean getIsNurse() {
    return this.isNurse;
  }

  public void setIsNurse(boolean isNurse) {
    this.isNurse = isNurse;
  }

  public Set<Appointment> getAppointments() {
    return this.appointments;
  }

  public void setAppointments(Set<Appointment> appointments) {
    this.appointments = appointments;
  }

}