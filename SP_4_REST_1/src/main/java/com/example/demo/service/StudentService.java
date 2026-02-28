package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	private StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	//getting all
	public List<Student> getAllStudent(){
		return studentRepository.findAll();
	}
	
	//creating 
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	//deleting
	public void deleteStudent(Long id) {
		if (!studentRepository.existsById(id)) {
		    throw new RuntimeException("Id not found");
		}

		studentRepository.deleteById(id);
	}
	
	//edit 
	public Student updateStudent(Student student, Long id) {
		if (!studentRepository.existsById(id)) {
		    throw new RuntimeException("Id not found");
		}
		student.setId(id);
		return studentRepository.save(student);
	}
	
	//getting 
	public Optional<Student> getStudentById(Long id) {
		return studentRepository.findById(id);
	}
	
}
