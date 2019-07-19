package com.example.clinic.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Employee
 */
@Entity(name = "employees")
public class Employee {

  @Column(name = "id")
  private Long id;

  @Column(name = "employeeName")
  private String employeeName;

  @Column(name = "isNurse")
  private boolean isNurse;

  @JsonManagedReference
  @OneToMany(mappedBy = "employee")
  private Set<Employee> employees;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public Set<Employee> getEmployees() {
    return this.employees;
  }

  public void setEmployees(Set<Employee> employees) {
    this.employees = employees;
  }

}