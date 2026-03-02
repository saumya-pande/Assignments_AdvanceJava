package com.springmvc.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springmvc.demo.exception.StudentNotFoundException;
import com.springmvc.demo.model.Student;
import com.springmvc.demo.repository.StudentRepository;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student student) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id));

        existingStudent.setName(student.getName());
        existingStudent.setCity(student.getCity());

        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long id) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id));

        studentRepository.delete(existingStudent);
    }
}