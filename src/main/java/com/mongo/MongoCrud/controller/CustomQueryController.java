package com.mongo.MongoCrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.MongoCrud.model.Book;
import com.mongo.MongoCrud.service.BookService;

@RestController
public class CustomQueryController {
	
	@Autowired
	BookService bookService;
	
	
	@RequestMapping("/getBookById/{bookId}")
	public Optional<Book> getBookById(@PathVariable ("bookId") int bookId) {
		System.out.println("bookId "+bookId);
		return bookService.getBookById(bookId);
	}
	
	@RequestMapping("/getBookByPrice")
	public List<Book> getBookById(@RequestParam("price") double price) {
		System.out.println("price "+price);
		return bookService.getBookByPrice(price);
		
	}
	
	@RequestMapping("/getBookByAuthPrice")
	public List<Book> getBookById(@RequestParam("author") String author,@RequestParam("price") double price) {
		System.out.println("author "+author);
		return bookService.getBookByAuthorAndPrice(author, price);
		
	}
	
	@RequestMapping("/getBookCountByAuthor")
	public int getBookCountByAuthor(@RequestParam("author") String author) {
		System.out.println("author "+author);
		return bookService.getBookCountByAuthor(author);
		
	}
	
	@RequestMapping("/getBookCountBySortedAuthor")
	public List<Book> getBookCountBySortedAuthor(@RequestParam("author") String author) {
		System.out.println("author "+author);
		return bookService.getBookCountBySortedAuthor(author);
		
	}
	
	@RequestMapping("/getBookNameAndAuthorNameByPages")
	public List<Book> getBookNameAndAuthorNameByPages(@RequestParam("pages") int pages) {
		System.out.println("pages "+pages);
		return bookService.getBookNameAndAuthorNameByPages(pages);
		
	}
	
	@RequestMapping("/getBookByRegex/{regex}")
	public List<Book> getBookByRegex(@PathVariable("regex") String regex) {
		System.out.println("regex "+regex);
		return bookService.getBookByRegex(regex);
		
	}
	
	@RequestMapping("/getBook")
	public List<Book> getBook() {
		return bookService.getBook();
		
	}
	
	@RequestMapping("/getBookWithMultiCond")
	public List<Book> getBookWithMultiCond(@RequestParam String name, @RequestParam int min, @RequestParam int max) {
		return bookService.getBookWithMultiCond(name, min,max);
		
	}
	
	
	

}
