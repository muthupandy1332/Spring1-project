package com.AnudipSprint.EmployeeSystem.services;

import java.util.List;

import com.AnudipSprint.EmployeeSystem.entity.Department;


public interface DepartmentService {
	
	Department saveDepartment(Department department);
    List<Department> getAllDepartments();
    Department getDepartmentById(Long did);
    Department updateDepartment(Department department, long did);
    void deleteDepartment(Long did);
}
