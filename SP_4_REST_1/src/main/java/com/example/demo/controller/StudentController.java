package com.example.demo.controller;
import java.util.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping
	public List<Student> getStudents(){
		return studentService.getAllStudent();
	}
	
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@GetMapping("/{id}")
	public Optional<Student> getStudentById(@PathVariable Long id){
		return studentService.getStudentById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudentById(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "student deleted successfully";
	}
	
	@PutMapping("/update/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
		return studentService.updateStudent(student, id);
	}
	
}