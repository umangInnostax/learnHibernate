package com.javaGuides.springboot_hibernate.service;

import java.util.List;

import com.javaGuides.springboot_hibernate.model.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();  
    Employee getEmployeeById(long id);  
    Employee updateEmployee(Employee employee, long id);
    Employee deletEmployeeById(long id);
}
