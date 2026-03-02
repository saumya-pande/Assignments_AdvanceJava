package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@Controller
public class CustomerController {
	
	public CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("/customers")
	public String showCustomers(Model model) {
		List<Customer> customerList = customerService.getAllCustomers();
		model.addAttribute("customers", customerList);
	    return "customers";
	}
	
	@GetMapping("/addCustomer")
	public String showAddFormModel(Model model) {
		model.addAttribute("customer", new Customer());
		return "addCustomer";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customers"; 
	}
}
