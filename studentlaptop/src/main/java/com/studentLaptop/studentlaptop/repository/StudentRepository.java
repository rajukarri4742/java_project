package com.studentLaptop.studentlaptop.repository;

import org.springframework.data.repository.CrudRepository;

import com.studentLaptop.studentlaptop.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

}
