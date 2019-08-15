package com.example.clinic.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * AllAppointment
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity(name = "appointment")
public class AllAppointment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "queueNum")
  private int queueNum;

  @Column(name = "employeeId")
  private Long employeeId;

  @Column(name = "checkInTime")
  private LocalDateTime checkInTime;

  @Column(name = "checkOutTime")
  private LocalDateTime checkOutTime;

  @Column(name = "symptom")
  private String symptom;

  @Column(name = "isToday")
  private Boolean isToday;

  @Column(name = "lastUpdBy")
  private Long lastUpdBy;

  @Column(name = "status")
  private String status;

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

  public Long getEmployeeId() {
    return this.employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public LocalDateTime getCheckInTime() {
    return this.checkInTime;
  }

  public void setCheckInTime(LocalDateTime checkInTime) {
    this.checkInTime = checkInTime;
  }

  public LocalDateTime getCheckOutTime() {
    return this.checkOutTime;
  }

  public void setCheckOutTime(LocalDateTime checOutTime) {
    this.checkOutTime = checOutTime;
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

  public long getLastUpdBy() {
    return this.lastUpdBy;
  }

  public void setLastUpdBy(long lastUpdBy) {
    this.lastUpdBy = lastUpdBy;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}