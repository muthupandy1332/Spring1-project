package com.AnudipSprint.EmployeeSystem.services.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.AnudipSprint.EmployeeSystem.entity.Department;
import com.AnudipSprint.EmployeeSystem.exception.ResourceNotFoundException;
import com.AnudipSprint.EmployeeSystem.repository.DepartmentRepository;
import com.AnudipSprint.EmployeeSystem.services.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
 

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long did) {
        return departmentRepository.findById(did)
                .orElseThrow(() -> new ResourceNotFoundException("Department","did",did));
    }

   
    @Override
    public  Department updateDepartment(Department department, long did) {
        Department existingDepartment = departmentRepository.findById(did)
                .orElseThrow(() -> new ResourceNotFoundException("Department","did",did));

        existingDepartment.setName(department.getName());
       
        existingDepartment.setLocation(department.getLocation());
        existingDepartment.setManager(department.getManager());
        existingDepartment.setDescription(department.getDescription());

        return departmentRepository.save(existingDepartment);
    }
    
	@Override
	public void deleteDepartment(Long did) {
		
		// check whether a employee exist in a DB or not
		departmentRepository.findById(did).orElseThrow( 
				() -> new ResourceNotFoundException("Department", "did", did));
		departmentRepository.deleteById(did);
	}

}


