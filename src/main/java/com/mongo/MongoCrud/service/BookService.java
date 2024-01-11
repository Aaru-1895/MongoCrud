package com.mongo.MongoCrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.MongoCrud.model.Book;
import com.mongo.MongoCrud.repo.MongoRepository;

@Service
public class BookService {
	
	
	@Autowired
	MongoRepository mongoRepository;
	
	
	public Optional<Book> getBookById(int id) {
	Optional<Book>	bookData= mongoRepository.getBookById(id);
	if(bookData.isPresent()) {
        System.out.println(bookData.get());
		}
	else {
       System.out.println("DATA NOT FOUND");
	}
	return Optional.of(bookData.get());
	}
	
	
	
	public List<Book> getBookByPrice(double price){
		List<Book> book= null;
		try {
			book= mongoRepository.getBookByPrice(price);
			System.out.println("book.."+book);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return book;
	}
	
	public List<Book> getBookByAuthorAndPrice(String name,double price){
		List<Book> book= null;
		try {
			book= mongoRepository.getBookByAuthorAndPrice(name,price);
			System.out.println("book.."+book);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return book;
	}
	
	public int getBookCountByAuthor(String name){
		int book= 0;
		try {
			book= mongoRepository.getBookCountByAuthor(name);
			System.out.println("book.."+book);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return book;
	}
	
	
	public List<Book> getBookCountBySortedAuthor(String name){
		List<Book> book= null;
		try {
			book= mongoRepository.getBookCountBySortedAuthor(name);
			System.out.println("book.."+book);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return book;
	}
	
	
	public List<Book> getBookNameAndAuthorNameByPages(int pages){
		List<Book> book= null;
		try {
			book= mongoRepository.getBookNameAndAuthorNameByPages(pages);
			System.out.println("book.."+book);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return book;
	}
	
	public List<Book> getBookByRegex(String regex){
		List<Book> book= null;
		try {
			book= mongoRepository.getBookByRegex(regex);
			System.out.println("book.."+book);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return book;
	}
	
	
	public List<Book> getBook(){
		List<Book> book= null;
		try {
			book= mongoRepository.getBook();
			System.out.println("book.."+book);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return book;
	}
	
	
	public List<Book> getBookWithMultiCond(String authorName, int minval, int maxVal){
		List<Book> book= null;
		try {
			//book= mongoRepository.getBookWithMultiCond(authorName, min, max);
			book= mongoRepository.getBookWithMultiCond(authorName,minval,maxVal);
			System.out.println("book.."+book);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return book;
	}
	
	

}
