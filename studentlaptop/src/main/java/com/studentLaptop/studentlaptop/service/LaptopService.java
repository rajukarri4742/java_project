package com.studentLaptop.studentlaptop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentLaptop.studentlaptop.model.Laptop;
import com.studentLaptop.studentlaptop.repository.LaptopRepository;

@Service
public class LaptopService {
	
	@Autowired
	private LaptopRepository laptopRepository;
	
	public Optional<Laptop> getLaptop(int id) {
		return laptopRepository.findById(id);
	}

	public void updateLaptop(int id, Laptop laptop) {
		laptopRepository.save(laptop);
		
	}

	public void addLaptop(Laptop laptop) {
		laptopRepository.save(laptop);
		
	}

	public void deleteLaptop(int id) {
		laptopRepository.deleteById(id);
		
	}

}
