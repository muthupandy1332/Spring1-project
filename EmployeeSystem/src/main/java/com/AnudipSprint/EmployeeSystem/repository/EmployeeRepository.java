package com.AnudipSprint.EmployeeSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AnudipSprint.EmployeeSystem.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Custom query methods, if needed
}

