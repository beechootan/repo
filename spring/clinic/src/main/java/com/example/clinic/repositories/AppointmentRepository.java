package com.example.clinic.repositories;

import java.util.List;

import com.example.clinic.entities.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AppointmentRepository
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
  List<Appointment> findAllByIsToday(Boolean isToday);

  List<Appointment> findAllByStatus(String status);

}