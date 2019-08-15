package com.example.clinic.repositories;

import java.util.List;
import java.util.Optional;

import com.example.clinic.entities.AllAppointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * AllAppointmentRepository
 */
public interface AllAppointmentRepository extends JpaRepository<AllAppointment, Long> {

  // @Query(value = "SELECT a.*, e.email, e.employeeName, e.badgeNumber FROM
  // appointment a, employee e WHERE a.employeeId = e.id AND a.isToday = 1 ORDER
  // BY queueNum ASC", nativeQuery = true)
  @Query(value = "SELECT * FROM appointment WHERE isToday = 1 ORDER BY queueNum ASC", nativeQuery = true)
  List<AllAppointment> findByIsToday();

  // List<Appointment> findAllByStatus(String status);
  @Query(value = "SELECT * FROM appointment a WHERE employeeId=?1 AND a.status='Open' AND a.isToday = 1", nativeQuery = true)
  AllAppointment findCurrentAppointmentById(Long id);

  // @Query(value = "SELECT * FROM appointment WHERE id=?1", nativeQuery = true)
  // AllAppointment findById(Long id);
}