package com.studentLaptop.studentlaptop.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.studentLaptop.studentlaptop.model.Laptop;
import com.studentLaptop.studentlaptop.model.Student;
import com.studentLaptop.studentlaptop.repository.LaptopRepository;
import com.studentLaptop.studentlaptop.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	LaptopRepository laptopRepository;

	public Optional<Student> getStudent(int id) {
		return studentRepository.findById(id);
	}

	public Student updateStudent(int id, Student student) {
		
		List<Student> students = (List<Student>) studentRepository.findAll();
		
		for(Student std: students) {
			
			if(std.getId() == id) {
				
				std.setId(student.getId());
				std.setGender(student.getGender());
				std.setName(student.getName());
				std.setLaptops(student.getLaptops());
				studentRepository.save(std);
				return std;
			}
		}
		studentRepository.save(student);
		return student;
	}

	public void addStudent(Student student) {
		
		studentRepository.save(student);
		
	}

	public void deleteStudent(int id) {
		
		studentRepository.deleteById(id);
		
	}

	public void addLaptop(int id, Laptop lapi) {
		
		Optional<Student> std=studentRepository.findById(id);
		
		if(std.isPresent()) {
			
			Student s = std.get();
			List<Laptop> laptops= s.getLaptops();
			laptops.add(lapi);
			s.setLaptops(laptops);
			studentRepository.save(s);
					
		}
		 
		
		
		
		studentRepository.save(null);
		
	}

	public String addLaptop(int std_id, int lap_id) {
		
		Optional<Student> s= studentRepository.findById(std_id);
		if(s.isPresent()) {
			
			Student student = s.get();
			Optional<Laptop> lapi=laptopRepository.findById(lap_id);
			if(lapi.isPresent()) {
				
	
				Laptop lap = lapi.get();
				if(lap.getStudent() != null) {
					
					Student std = lap.getStudent();
					return "Laptop assigned to " + std.toString();
					
				}else {
					
					student.setLaptops(new ArrayList<Laptop>(List.of(lap)));
					lap.setStudent(student);
					laptopRepository.save(lap);
					studentRepository.save(student);
					return "Laptop = " + lap.toString() + " assigned to Student = " + student.toString();
				}
				
				
			}else {
				return "laptop not present";
			}
			
		}else {
			return "student not present";
		}		
		
	}	

}
