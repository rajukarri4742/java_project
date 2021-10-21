package com.springboot.studentbooks.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.studentbooks.model.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {

}
