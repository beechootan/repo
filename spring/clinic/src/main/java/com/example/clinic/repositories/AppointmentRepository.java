package com.example.clinic.repositories;

import java.util.List;

import com.example.clinic.entities.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * AppointmentRepository
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
  // List<Appointment> findAllByIsToday(Boolean isToday);

  @Query(value = "SELECT * FROM appointment WHERE isToday = 1 ORDER BY queueNum ASC", nativeQuery = true)
  List<Appointment> findAllByIsToday();

  // List<Appointment> findAllByStatus(String status);
  @Query(value = "SELECT * FROM appointment a WHERE employeeId=?1 AND a.status='Open' AND a.isToday = 1", nativeQuery = true)
  Appointment findCurrentAppointmentById(Long id);

  // List<Appointment> findAllByStatus(String status);
  @Query(value = "SELECT * FROM employee e, appointment a WHERE e.id= a.employeeId AND e.employeeName=?1 AND a.status='Open' AND a.isToday = 1", nativeQuery = true)
  Appointment findCurrentAppointmentByEmployeeName(String employeeName);

  Appointment findByStatus(String status);

  // @Query(value = "SELECT * FROM appointment WHERE isToday = 1 AND queueNum =
  // (SELECT MAX(queueNum) FROM appointment WHERE isToday = 1 AND status IN
  // ('Completed','Cancel'))", nativeQuery = true)
  @Query(value = "SELECT * FROM appointment WHERE isToday = 1 AND queueNum = (SELECT MIN(queueNum) FROM appointment WHERE isToday = 1 AND status IN ('In Progress','Open'))", nativeQuery = true)
  Appointment findCompleted();

  @Query(value = "SELECT * FROM appointment WHERE isToday = 1 AND queueNum = (SELECT MAX(queueNum) FROM appointment WHERE isToday = 1 AND status IN ('Completed'))", nativeQuery = true)
  Appointment findByMaxCompleted();

  @Query(value = "SELECT TOP 1 * FROM appointment WHERE isToday = 1 order by queueNum desc", nativeQuery = true)
  Appointment findByIsToday();

  @Query(value = "select * FROM appointment WHERE queueNum = (SELECT MAX(queueNum) FROM appointment WHERE isToday = 1) AND isToday = 1", nativeQuery = true)
  Appointment findTotalQueue();
}