package com.AnudipSprint.EmployeeSystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnudipSprint.EmployeeSystem.entity.Department;
import com.AnudipSprint.EmployeeSystem.entity.Employee;
import com.AnudipSprint.EmployeeSystem.exception.ResourceNotFoundException;
import com.AnudipSprint.EmployeeSystem.services.DepartmentService;
import com.AnudipSprint.EmployeeSystem.services.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private  EmployeeService employeeService;
    private  DepartmentService departmentService;

    public EmployeeController(EmployeeService employeeService,DepartmentService departmentService) {
    	super();
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

   
    @PostMapping("/add{did}")
    public ResponseEntity<Employee> saveEmployee(@PathVariable("did") Long did, @RequestBody Employee employee) {
        // Retrieve the department by ID
        Department department = departmentService.getDepartmentById(did);
        
        // Set the department for the employee
        employee.setDepartment(department);
        
        // Save the employee
        Employee savedEmployee = employeeService.saveEmployee(employee);
        
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    
    
    @GetMapping("/getallEmp")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get/{eid}")
    public ResponseEntity<String> getEmployeeById(@PathVariable("eid") long eid){
    	
    	try {
    		Employee empObject = employeeService.getEmployeeById(eid);
			return new ResponseEntity<String>(empObject.toString(), HttpStatus.OK);
    	}
    	catch (ResourceNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}


    @PutMapping("/update/{eid}")
	public ResponseEntity<String> updateEmployee(@PathVariable("eid") long eid
												  ,@RequestBody Employee employee){
    	try {
    	Employee updatedEmployee = employeeService.updateEmployee(employee, eid);
		return new ResponseEntity<String>(updatedEmployee.toString(), HttpStatus.OK);
	} 
    	catch (ResourceNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
    }
	
    
    @DeleteMapping("/delete/{eid}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("eid") long eid){
		try {
		// delete employee from DB
		employeeService.deleteEmployee(eid);
		
		return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
	    } 
		catch (ResourceNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
         }
    }
}