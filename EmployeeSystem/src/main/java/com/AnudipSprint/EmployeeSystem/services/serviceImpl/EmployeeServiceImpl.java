package com.AnudipSprint.EmployeeSystem.services.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.AnudipSprint.EmployeeSystem.entity.Employee;
import com.AnudipSprint.EmployeeSystem.exception.ResourceNotFoundException;
import com.AnudipSprint.EmployeeSystem.repository.EmployeeRepository;
import com.AnudipSprint.EmployeeSystem.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
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
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee","id",id));
    }
    

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee","id",id));
        
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setDesignation(employee.getDesignation());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setAddress(employee.getAddress());
        existingEmployee.setPhoneNumber(employee.getPhoneNumber()); 
        existingEmployee.setDepartment(employee.getDepartment());

        return employeeRepository.save(existingEmployee);
    }
    
	@Override
	public void deleteEmployee(Long id) {
		
		// check whether a employee exist in a DB or not
		employeeRepository.findById(id).orElseThrow( 
				() -> new ResourceNotFoundException("Employee", "id", id));
		employeeRepository.deleteById(id);
	}
    }

