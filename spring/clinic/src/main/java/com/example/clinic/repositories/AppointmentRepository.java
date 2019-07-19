package com.example.clinic.repositories;

import java.util.List;

import com.example.clinic.entities.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * AppointmentRepository
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
  List<Appointment> findAllByIsToday(Boolean isToday);

  @Query(value = "SELECT * FROM appointment WHERE checkInTime is not null AND checkOutTime is null AND cancel = 0 AND isToday = 1; ", nativeQuery = true)
  List<Appointment> findCurrentQueue();

  // @Query(value = "SELECT * from appointment where id = ?1 and checkInTime is
  // null and checkOutTime is null and cancel = 0 and isToday = 1; ", nativeQuery
  // = true)
  // Appointment findCurrentAppointment(Long id);

}