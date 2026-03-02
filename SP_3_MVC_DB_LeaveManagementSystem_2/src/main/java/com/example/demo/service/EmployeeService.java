package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.LeaveRequestRepository;

@Service
public class EmployeeService {
	 @Autowired
	 private EmployeeRepository employeeRepository;
	 
	 //view
	 public List<Employee> getAllEmployees(){
		 return employeeRepository.findAll();
	 }
	 
	 //add
	 public Employee addNewEmployee(Employee employee) {
		 return employeeRepository.save(employee);
	 }
	 
	 //update
	 public Employee updateEmployee(Long id, Employee employee) {
		 if(!employeeRepository.existsById(id)) {
			 throw new RuntimeException("The employee does not exist of id : " + id);
		 }
		 employee.setEmployeeId(id);
		 return employeeRepository.save(employee);
	 }
	 
	 //delete
	 public void deleteEmployee(Long id) {
		 if(!employeeRepository.existsById(id)) {
			 throw new RuntimeException("The employee does not exist of id : " + id);
		 }
		 employeeRepository.deleteById(id);
	 }
	 
	 //get by id
	 public Employee getEmployeeById(long id) {
		 if(!employeeRepository.existsById(id)) {
			 throw new RuntimeException("The employee not found by id : " + id);
		 }
		 return employeeRepository.findById(id).orElse(null);
	 }
}
