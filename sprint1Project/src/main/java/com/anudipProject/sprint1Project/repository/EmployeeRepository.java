package com.anudipProject.sprint1Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anudipProject.sprint1Project.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

