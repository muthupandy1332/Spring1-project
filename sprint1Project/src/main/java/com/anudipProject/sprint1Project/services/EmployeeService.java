package com.anudipProject.sprint1Project.services;

import java.util.List;

import com.anudipProject.sprint1Project.entity.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee, long id);
	void deleteEmployee(long id);
}
