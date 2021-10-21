package com.studentLaptop.studentlaptop.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Laptop {
	
	@Id
	private int id;
	private String model;
	
	@JsonBackReference
	@ManyToOne
	private Student student;

	public Laptop() {}
	
	public Laptop(int id, String model, Student student) {

		this.id = id;
		this.model = model;
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(id, model, student);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laptop other = (Laptop) obj;
		return id == other.id && Objects.equals(model, other.model) && Objects.equals(student, other.student);
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", model=" + model ;
	}
	
	

}
