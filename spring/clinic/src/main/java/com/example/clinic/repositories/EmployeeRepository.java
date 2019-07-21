package com.example.clinic.repositories;

import com.example.clinic.entities.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  // @Query(value = "SELECT * from employee e, appointment a where e.id =
  // a.employeeId and a.checkInTime is null and a.checkOutTime is null and
  // a.cancel = 0 and a.isToday = 1 and e.employeeName = ?1; ", nativeQuery =
  // true)
  Employee findByEmployeeName(String employeeName);

}