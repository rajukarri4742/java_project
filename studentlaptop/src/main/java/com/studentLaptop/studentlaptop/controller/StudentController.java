package com.studentLaptop.studentlaptop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.studentLaptop.studentlaptop.model.Laptop;
import com.studentLaptop.studentlaptop.model.Student;
import com.studentLaptop.studentlaptop.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@RequestMapping(value = "/get/student/{id}", method = RequestMethod.GET)
	public Optional<Student> getStudent(@PathVariable int id) {
		
		return service.getStudent(id);
	}
	
	@RequestMapping(value = "/update/student/{id}", method = RequestMethod.PUT)
	public void updateStudent(@RequestBody Student student,@PathVariable int id) {
		
		service.updateStudent(id,student);
	}
	
	@RequestMapping(value = "/add/student", method = RequestMethod.POST)
	public void addStudent(@RequestBody Student student) {
		
		service.addStudent(student);
	}
	
	@RequestMapping(value = "/student/delete/{id}", method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable int id) {
		
		service.deleteStudent(id);
	}
	
	@RequestMapping(value = "/update/addLaptopToStudent/{id}", method = RequestMethod.PUT)
	public void addLaptop(@RequestBody Laptop lapi,@PathVariable int id) {
		
		service.addLaptop(id,lapi);
	}
	
	@RequestMapping(value = "/update/addLaptopToStudent/{std_id}/{lap_id}", method = RequestMethod.PUT)
	public String addLaptop(@PathVariable int std_id, @PathVariable int lap_id) {
		
		return service.addLaptop(std_id, lap_id);
	}
	
	
	
	
	
	
	
	
	
	
}
