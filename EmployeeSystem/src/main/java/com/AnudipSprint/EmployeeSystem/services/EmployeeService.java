package com.AnudipSprint.EmployeeSystem.services;

import java.util.List;

import com.AnudipSprint.EmployeeSystem.entity.Employee;

public interface EmployeeService {
	
	    List<Employee> getAllEmployees();
	    Employee getEmployeeById(Long id);
	    Employee saveEmployee(Employee employee);
	    Employee updateEmployee(Employee employee,long id);
	    void deleteEmployee(Long id);
	}


