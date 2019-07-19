package com.example.clinic.repositories;

import com.example.clinic.entities.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * AppointmentRepository
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
  @Query("SELECT a FROM Appointment a WHERE a.checkInTime is not null and checkOutTime is null and cancel = false and isToday = true")
  Appointment findCurrentQueue();
}