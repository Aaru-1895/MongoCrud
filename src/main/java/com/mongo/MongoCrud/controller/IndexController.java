package com.mongo.MongoCrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.MongoCrud.model.Book;
import com.mongo.MongoCrud.model.User;
import com.mongo.MongoCrud.repo.UserRepository;

@RestController

public class IndexController {
	
	@Autowired
	MongoRepository mongoRepository;
	
	
	@Autowired
	UserRepository userRepository;
	
	
	@PostMapping("/saveBook")
	public  ResponseEntity<String> saveBook(@RequestBody Book book){
		System.out.println("book..."+book.getBookName());
		try {
			mongoRepository.save(book);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		 return new ResponseEntity<>("Book Saved successfully!", HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllBook")
	public Optional getAllBook() {
		Optional bookList=null;
	try {
		System.out.println("calling................");
		bookList= mongoRepository.findById(1555);
		System.out.println("bookList..."+bookList);
	} catch (Exception e) {
		System.out.println("error message.."+e.getMessage());
	}
		return bookList;
		
	}
	
	
	@PostMapping("/saveuser")
	public  ResponseEntity<String> saveBook(@RequestBody User user){
		System.out.println("book..."+user);
		try {
			userRepository.save(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		 return new ResponseEntity<>("user Saved successfully!", HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllUser")
	public List<User> getAllUser() {
		List<User> userList=null;
	try {
		System.out.println("calling................");
		userList= userRepository.findAll();
		System.out.println("bookList..."+userList);
	} catch (Exception e) {
		System.out.println("error message.."+e.getMessage());
	}
		return userList;
		
	}
	

} 
