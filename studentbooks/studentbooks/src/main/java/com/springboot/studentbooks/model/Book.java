package com.springboot.studentbooks.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Book {
	
	@Id
	private int id;
	private String name;
	private String author;
	
	@ManyToMany
	List<Student> stds= new ArrayList<Student>();

	public Book() {
		
	}

	public Book(int id, String name, String author, List<Student> std) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.stds = std;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Student> getStd() {
		return stds;
	}

	public void setStd(List<Student> std) {
		this.stds = std;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", std=" + stds + "]";
	}
	

}
