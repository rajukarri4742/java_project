package com.springboot.studentbooks.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.studentbooks.model.Student;


public interface StudentRepository extends CrudRepository<Student,Integer> {

}
