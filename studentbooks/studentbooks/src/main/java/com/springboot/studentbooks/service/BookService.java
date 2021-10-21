package com.springboot.studentbooks.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.studentbooks.model.Book;
import com.springboot.studentbooks.model.Student;
import com.springboot.studentbooks.repository.BookRepository;
import com.springboot.studentbooks.repository.StudentRepository;

@Service
public class BookService {
	
	@Autowired(required=true)
	BookRepository bookRepository;
	
	@Autowired(required=true)
	StudentRepository stdRepository;

	public Iterable<Book> getAllBook() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	public Optional<Book> getBook(int id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id);
	}

	public void addBook(Book bk) {
		// TODO Auto-generated method stub
		bookRepository.save(bk);
		
	}

	public void updateBook(Book bk, int id) {
		// TODO Auto-generated method stub
		
		Optional<Book> std = bookRepository.findById(id);
		if(std.isPresent()) {
			Book s=std.get();
			s.setId(bk.getId());
			s.setName(bk.getName());
			s.setAuthor(bk.getAuthor());
			s.setStd(bk.getStd());
			
			bookRepository.save(s);
		}
		
	}

	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
	}

	public void updateStdInBook(int sId, int bId) {
		Optional<Book> bk = bookRepository.findById(bId);
		if(bk.isPresent()) {
			
			Optional<Student> std = stdRepository.findById(sId);
			
			if(std.isPresent()) {
				
				Book book=bk.get();
				Student student=std.get();
				
				
			}
			
			
		}
		
	}

}
