package com.springmvc.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springmvc.demo.model.Student;
import com.springmvc.demo.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping
	public ResponseEntity<List<Student>> getStudents() {
		return ResponseEntity.ok(studentService.getAllStudents());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		Student student = studentService.getStudentById(id);
		return ResponseEntity.ok(student);
	}

	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		Student savedStudent = studentService.createStudent(student);
		return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
		Student updatedStudent = studentService.updateStudent(id, student);
		return ResponseEntity.ok(updatedStudent);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return ResponseEntity.ok("Student deleted successfully");
	}
}