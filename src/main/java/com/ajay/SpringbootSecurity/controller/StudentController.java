package com.ajay.SpringbootSecurity.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.SpringbootSecurity.model.Student;
import com.ajay.SpringbootSecurity.service.StudentService;

import java.util.List;

@RestController
public class StudentController {

	@Autowired
	private StudentService StudentService;
	
    @GetMapping("/students")
    public List<Student> getStudents() {
        return StudentService.getStudents();
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
    	StudentService.saveStudent(student);
        return student;
    }

}
