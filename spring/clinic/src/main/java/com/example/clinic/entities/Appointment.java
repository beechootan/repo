package com.example.clinic.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Appointment
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity(name = "appointment")
public class Appointment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "queueNum")
  private int queueNum;

  @Column(name = "checkInTime")
  private Date checkInTime;

  @Column(name = "checkOutTime")
  private Date checOutTime;

  @Column(name = "symptom")
  private String symptom;

  @Column(name = "isToday")
  private Boolean isToday;

  @Column(name = "lastUpdBy")
  private int lastUpdBy;

  @Column(name = "status")
  private String status;

  @ManyToOne
  @JoinColumn(name = "employeeId")
  private Employee employee;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getQueueNum() {
    return this.queueNum;
  }

  public void setQueueNum(int queueNum) {
    this.queueNum = queueNum;
  }

  public Date getCheckInTime() {
    return this.checkInTime;
  }

  public void setCheckInTime(Date checkInTime) {
    this.checkInTime = checkInTime;
  }

  public Date getChecOutTime() {
    return this.checOutTime;
  }

  public void setChecOutTime(Date checOutTime) {
    this.checOutTime = checOutTime;
  }

  public String getSymptom() {
    return this.symptom;
  }

  public void setSymptom(String symptom) {
    this.symptom = symptom;
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

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Employee getEmployee() {
    return this.employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

}