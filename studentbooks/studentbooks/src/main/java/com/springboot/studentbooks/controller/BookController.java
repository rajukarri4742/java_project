package com.springboot.studentbooks.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.studentbooks.model.Book;
import com.springboot.studentbooks.service.BookService;

@RestController
public class BookController {
	
	@Autowired(required=true)
	private BookService service;
	
	@RequestMapping(value="/get/book",method=RequestMethod.GET)
	public Iterable<Book> getAllBooks() {
		return service.getAllBook();
	}
	
	@RequestMapping(value="/get/book/{id}",method=RequestMethod.GET)
	public Optional<Book> getStudent(@PathVariable int id)
	{
		return service.getBook(id);
	}
	
	@RequestMapping(value="/add/book",method=RequestMethod.POST)
	public void addBook(@RequestBody Book bk) {
		service.addBook(bk);
	}
	
	@RequestMapping(value="/update/book/{id}",method=RequestMethod.PUT)
	public void updateBook(@RequestBody Book bk,@PathVariable int id) {
		service.updateBook(bk,id);
	}
	
	@RequestMapping(value="/delete/book/{id}",method=RequestMethod.DELETE)
	public void deleteBook(@PathVariable int id) {
		service.deleteBook(id);
	}
	
	@RequestMapping(value="/updateStudentInBook/{sId}/{bId}",method=RequestMethod.PUT)
	public void updateStdInBook(@PathVariable int sId,@PathVariable int bId) {
		service.updateStdInBook(sId,bId);
	}

}
