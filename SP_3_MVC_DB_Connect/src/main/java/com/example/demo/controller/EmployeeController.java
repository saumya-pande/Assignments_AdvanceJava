package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.websocket.server.PathParam;

@Controller
public class EmployeeController {
	
	public EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employee")
	public String getEmployees(Model model) {
	    List<Employee> employees = employeeService.getAllEmployees();
	    System.out.println("SIZE = " + employees.size());
	    model.addAttribute("employees", employees);
	    return "employee";
	}
	
	@GetMapping("/employees")
	public ModelAndView getEmployeeDetails() {
		List<Employee> employees = employeeService.getAllEmployees();
		ModelAndView mv = new ModelAndView();
		mv.addObject("employees", employees);
		mv.setViewName("employee");
		return mv;
	}
	
	@GetMapping("/addEmployee")
	public String showAddForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "addEmployee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/edit/{id}")
	public String editEmployee(@PathVariable Long id, Model model) {

	    Employee employee = employeeService.getEmployeeById(id);
	    model.addAttribute("employee", employee);
	    return "editEmployee";
	}
	
	@PostMapping("/update")
	public String updateEmployee(Employee employee) {

	    employeeService.saveEmployee(employee);
	    return "redirect:/employee";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Long id) {

	    employeeService.deleteEmployeeById(id);
	    return "redirect:/employee";
	}
}
