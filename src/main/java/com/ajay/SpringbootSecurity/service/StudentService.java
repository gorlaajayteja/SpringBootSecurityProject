package com.ajay.SpringbootSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.SpringbootSecurity.model.Student;
import com.ajay.SpringbootSecurity.repo.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}
	
	public List<Student> getStudents() {
		return studentRepo.findAll();
	}
}
