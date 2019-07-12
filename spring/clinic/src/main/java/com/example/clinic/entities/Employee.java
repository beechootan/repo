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

}