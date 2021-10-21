package com.springboot.studentbooks.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.studentbooks.model.Student;
import com.springboot.studentbooks.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired(required=true)
	private StudentService service;
	
	@RequestMapping(value="/get/students",method=RequestMethod.GET)
	public Iterable<Student> getAllStudents() {
		return service.getAllStd();
	}
	
	@RequestMapping(value="/get/student/{id}",method=RequestMethod.GET)
	public Optional<Student> getStudent(@PathVariable int id)
	{
		return service.getStudent(id);
	}
	
	@RequestMapping(value="/add/student",method=RequestMethod.POST)
	public void addStudent(@RequestBody Student std) {
		service.addStudent(std);
	}
	
	@RequestMapping(value="/update/student/{id}",method=RequestMethod.PUT)
	public void updateStudent(@RequestBody Student std,@PathVariable int id) {
		service.updateStudent(std,id);
	}
	
	@RequestMapping(value="/delete/student/{id}",method=RequestMethod.DELETE)
	public void deleteStudent(@PathVariable int id) {
		service.deleteStudent(id);
	}

}
