package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	public EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employee> getAllEmployees(){
		
		return employeeRepository.findAll();
	}
	
	public void saveEmployee(Employee e) {
		employeeRepository.save(e);
	}
	
	public Employee getEmployeeById(Long id) {
	    return employeeRepository.findById(id).orElse(null);
	}
	
	public void deleteEmployeeById(Long id) {
	    employeeRepository.deleteById(id);
	}
}
