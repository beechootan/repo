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

}