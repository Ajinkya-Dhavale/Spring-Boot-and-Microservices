package com.ajinkya.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajinkya.entity.Student;
import com.ajinkya.repo.StudentRepo;

@RestController
public class StudentRestController {

	@Autowired
	private StudentRepo repo;
	
	@GetMapping("/students")
	public Iterable<Student> getStudents() {
		return repo.findAll();
	}
	
	@PostMapping("/student")
	public String postMethodName(@RequestBody Student s) {
		repo.save(s);
		return "status : Student Save Successfully";
	}
	
}
