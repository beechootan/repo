package com.example.clinic.repositories;

import com.example.clinic.entities.DoctorStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * DoctorStatusRepository
 */
public interface DoctorStatusRepository extends JpaRepository<DoctorStatus, Long> {
  @Query(value = "SELECT TOP 1 * FROM doctor_status", nativeQuery = true)
  DoctorStatus findDoctorStatus();
}