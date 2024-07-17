package com.javaGuides.springboot_hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaGuides.springboot_hibernate.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
