package com.example.clinic.repositories;

import java.util.List;

import com.example.clinic.entities.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * AppointmentRepository
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
  // @Query("SELECT a FROM Appointment a WHERE a.checkInTime != null and
  // a.checkOutTime = null and a.cancel = 0 and a.isToday = 1")
  // Appointment findCurrentQueue();

  // @Query("SELECT a FROM Appointment a")
  // List<Appointment> findAll();
}