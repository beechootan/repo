package com.example.clinic.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Appointment
 */
@Entity(name = "appointment")
public class Appointment {
  @Column(name = "id")
  private String id;

  @Column(name = "queueNum")
  private int queueNum;

  @Column(name = "employeeId")
  private int employeeId;

  @Column(name = "checkInTime")
  private String checkInTime;

  @Column(name = "checkOutTime")
  private String checOutTime;

  @Column(name = "symptom")
  private String symptom;

  @Column(name = "cancel")
  private Boolean cancel;

  @Column(name = "isToday")
  private Boolean isToday;

  @Column(name = "lastUpdBy")
  private int lastUpdBy;

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "employeeId")
  private Employee employee;

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getQueueNum() {
    return this.queueNum;
  }

  public void setQueueNum(int queueNum) {
    this.queueNum = queueNum;
  }

  public int getEmployeeId() {
    return this.employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public String getCheckInTime() {
    return this.checkInTime;
  }

  public void setCheckInTime(String checkInTime) {
    this.checkInTime = checkInTime;
  }

  public String getChecOutTime() {
    return this.checOutTime;
  }

  public void setChecOutTime(String checOutTime) {
    this.checOutTime = checOutTime;
  }

  public String getSymptom() {
    return this.symptom;
  }

  public void setSymptom(String symptom) {
    this.symptom = symptom;
  }

  public Boolean isCancel() {
    return this.cancel;
  }

  public Boolean getCancel() {
    return this.cancel;
  }

  public void setCancel(Boolean cancel) {
    this.cancel = cancel;
  }

  public Boolean isIsToday() {
    return this.isToday;
  }

  public Boolean getIsToday() {
    return this.isToday;
  }

  public void setIsToday(Boolean isToday) {
    this.isToday = isToday;
  }

  public int getLastUpdBy() {
    return this.lastUpdBy;
  }

  public void setLastUpdBy(int lastUpdBy) {
    this.lastUpdBy = lastUpdBy;
  }

  public Employee getEmployee() {
    return this.employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

}