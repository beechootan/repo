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

  // List<Appointment> findAllByStatus(String status);
  @Query(value = "SELECT * FROM employee e, appointment a WHERE e.id= a.employeeId AND e.employeeName=?1 AND a.status='Open'", nativeQuery = true)
  Appointment findCurrentAppointmentByEmployeeName(String employeeName);

  Appointment findByStatus(String status);

  @Query(value = "SELECT TOP 1 * FROM appointment WHERE isToday = 1 order by queueNum desc", nativeQuery = true)
  Appointment findByIsToday();

  @Query(value = "select * FROM appointment WHERE queueNum = (SELECT MAX(queueNum) FROM appointment WHERE isToday = 1)", nativeQuery = true)
  Appointment findTotalQueue();
}