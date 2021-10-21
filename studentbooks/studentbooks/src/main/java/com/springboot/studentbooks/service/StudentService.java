package com.springboot.studentbooks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.studentbooks.model.Student;
import com.springboot.studentbooks.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired(required=true)
	StudentRepository stdRepository;

	public Iterable<Student> getAllStd() {
		return stdRepository.findAll();
	}

	public Optional<Student> getStudent(int id) {
		// TODO Auto-generated method stub
		return stdRepository.findById(id);
	}

	public void addStudent(Student std) {
		stdRepository.save(std);
		
	}

	public void updateStudent(Student student, int id) {
		Optional<Student> std = stdRepository.findById(id);
		if(std.isPresent()) {
			Student s=std.get();
			s.setrNo(student.getrNo());
			s.setName(student.getName());
			s.setcName(student.getcName());
			s.setBs(student.getBs());
			
			stdRepository.save(s);
		}
	}

	public void deleteStudent(int id) {
		stdRepository.deleteById(id);
		
	}

}
