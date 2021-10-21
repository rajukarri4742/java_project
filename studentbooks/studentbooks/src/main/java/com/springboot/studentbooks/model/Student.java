package com.springboot.studentbooks.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	
	@Id
	private int rNo;
	private String name;
	private String cName;
	
	@ManyToMany(mappedBy="stds")
	List<Book> bs= new ArrayList<Book>();

	public Student() {
		
	}

	public Student(int rNo, String name, String cName, List<Book> bs) {
		this.rNo = rNo;
		this.name = name;
		this.cName = cName;
		this.bs = bs;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public List<Book> getBs() {
		return bs;
	}

	public void setBs(List<Book> bs) {
		this.bs = bs;
	}

	@Override
	public String toString() {
		return "Student [rNo=" + rNo + ", name=" + name + ", cName=" + cName + ", bs=" + bs + "]";
	}
	
	
	
	
	
	

}
