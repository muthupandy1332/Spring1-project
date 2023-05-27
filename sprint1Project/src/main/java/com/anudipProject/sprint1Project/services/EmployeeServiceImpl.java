package com.anudipProject.sprint1Project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anudipProject.sprint1Project.entity.Employee;
import com.anudipProject.sprint1Project.exception.ResourceNotFoundException;
import com.anudipProject.sprint1Project.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long eid) {

		return employeeRepository.findById(eid).orElseThrow(() -> 
						new ResourceNotFoundException("Employee", "Eid", eid));
		
	}

	@Override
	public Employee updateEmployee(Employee employee, long eid) {
		
		// we need to check whether employee with given id is exist in DB or not
		Employee existingEmployee = employeeRepository.findById(eid).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "Eid", eid)); 
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setPost(employee.getPost());
		existingEmployee.setDepartment(employee.getDepartment());
		existingEmployee.setSalary(employee.getSalary());
		existingEmployee.setContact(employee.getContact());
		
		// save existing employee to DB
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}	

	@Override
	public void deleteEmployee(long eid) {
		
		// check whether a employee exist in a DB or not
		employeeRepository.findById(eid).orElseThrow(() -> 
								new ResourceNotFoundException("Employee", "Eid", eid));
		employeeRepository.deleteById(eid);
	}
	
}

