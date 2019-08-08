package com.example.clinic.repositories;

import com.example.clinic.entities.DoctorStatus;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DoctorStatusRepository
 */
public interface DoctorStatusRepository extends JpaRepository<DoctorStatus, Long> {

}