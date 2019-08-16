package com.example.clinic.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;

/**
 * Employee
 */
@Entity(name = "employee")
/**
 * EmployeeOnly
 */
public class EmployeeOnly {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "badgeNumber")
  private int badgeNumber;

  @Column(name = "employeeName")
  private String employeeName;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "isNurse")
  private boolean isNurse;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getBadgeNumber() {
    return this.badgeNumber;
  }

  public void setBadgeNumber(int badgeNumber) {
    this.badgeNumber = badgeNumber;
  }

  public String getEmployeeName() {
    return this.employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
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

}