package com.mongo.MongoCrud.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mongo.MongoCrud.model.Book;

@Repository
public interface MongoRepository extends org.springframework.data.mongodb.repository.MongoRepository<Book, Integer>{
	
	 //--------------------------------custom query methods------------------------
	
	@Query("{id:?0}")         //SQL Equivalent : SELECT * FROM BOOK WHERE ID=?
	Optional<Book> getBookById(int id);
	
	
	
	@Query("{price:{$gte:?0}}")     // SQL Equivalent : SELECT * FROM BOOK where pages>=?
	//@Query("{price:{$gt:?0}}")    // SQL Equivalent : SELECT * FROM BOOK where pages>?
	//@Query("{price:{$lt:?0}}")	// SQL Equivalent : SELECT * FROM BOOK where pages<?
	//@Query("{price:?0}")   	   // SQL Equivalent : SELECT * FROM BOOK where pages=?
	//@Query("{ 'price' : { $gt: ?0, $lt: ?1 } }")
	List<Book> getBookByPrice(double price);

	
	@Query("{authorName:?0,price:?1}")       // SQL Equivalent : SELECT * FROM BOOK where author = ? and price=?
	List<Book> getBookByAuthorAndPrice(String author,double price);
	
	
	@Query(value = "{authorName:?0}", count=true)   //SQL Equivalent : select count(*) from book where author=?
	Integer getBookCountByAuthor(String authorName);
	
	
	@Query(value = "{authorName:?0}", sort="{price:-1}") 
	//@Query(value = "{authorName:?0}", sort="{price:1}") //ASC  
	List<Book> getBookCountBySortedAuthor(String authorName);
	
	
	@Query("{authorName:{$nin : ['Aaru', 'Kiran Bedi']}}")
	//@Query("{authorName:{$in : ['Aaru', 'Kiran Bedi']}}")  // SELECT * FROM BOOK where authorName in('Aaru',Kiran Bedi);
	List<Book> getBook();
	
	
	@Query("{authorName:?0, pages:{$lt:?1, $gte:?2}}")
	/*
	 * List<Book> getBookWithMultiCond(String authorName , int minPage, int maxpage
	 * );
	 */
	List<Book> getBookWithMultiCond(String name,int minval, int maxVal);
	
	
	
	  //------------------- @Query with Projection ---------------------------------------
	
	
	@Query(value = "{pages:?0}",fields = "{bookName:1,authorName:1}")
	List<Book> getBookNameAndAuthorNameByPages(int pages);
	
	
	 //------------------MongoDB Regular Expressions--------------------------------------
	
	@Query("{authorName:{$regex:?0}}")
	List<Book> getBookByRegex(String regex);
}
