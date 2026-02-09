package com.ajinkya.repo;

import org.springframework.data.repository.CrudRepository;

import com.ajinkya.entity.Student;

public interface StudentRepo extends CrudRepository<Student, Integer>{

}