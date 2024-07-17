package com.javaGuides.springboot_hibernate.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.javaGuides.springboot_hibernate.exception.ResourceNotFoundException;
import com.javaGuides.springboot_hibernate.model.Employee;
import com.javaGuides.springboot_hibernate.repository.EmployeeRepository;
import com.javaGuides.springboot_hibernate.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

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
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id)
                                .orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmployee =  employeeRepository.findById(id)
                                                    .orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));
                    
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public Employee deletEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id)
                                            .orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));

        employeeRepository.deleteById(id);
        return employee;
    }

}
