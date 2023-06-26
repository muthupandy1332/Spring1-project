package com.AnudipSprint.EmployeeSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AnudipSprint.EmployeeSystem.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Custom query methods, if needed
}
