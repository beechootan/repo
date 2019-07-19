package com.example.clinic.repositories;

import com.example.clinic.entities.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AppointmentRepository
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}