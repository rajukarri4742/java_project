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
import com.studentLaptop.studentlaptop.service.LaptopService;

@RestController
public class LaptopController {
	
	@Autowired
	private LaptopService service;
	
	@RequestMapping(value = "/get/laptop/{id}", method = RequestMethod.GET)
	public Optional<Laptop> getLaptop(@PathVariable int id) {
		
		return service.getLaptop(id);
	}
	
	@RequestMapping(value = "/update/laptop/{id}", method = RequestMethod.PUT)
	public void updateLaptpo(@RequestBody Laptop laptop,@PathVariable int id) {
		
		service.updateLaptop(id,laptop);
	}
	
	@RequestMapping(value = "/add/laptop", method = RequestMethod.POST)
	public void addStudent(@RequestBody Laptop laptop) {
		
		service.addLaptop(laptop);
	}
	
	@RequestMapping(value = "/laptop/delete/{id}", method = RequestMethod.DELETE)
	public void deleteLaptop(@PathVariable int id) {
		
		service.deleteLaptop(id);
	}

}
