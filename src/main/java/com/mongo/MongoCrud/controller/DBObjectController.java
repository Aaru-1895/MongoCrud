package com.mongo.MongoCrud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mongodb.BasicDBObject;
/*import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;*/

@RestController
public class DBObjectController {

	/*
	 * @RequestMapping("/userDataInsert") public ResponseEntity<String> dataInsert()
	 * { DBCollection collection = null;
	 * 
	 * List<DBObject> list = new ArrayList<DBObject>();
	 * 
	 * try { System.out.println("userDataInsert calling....");
	 * 
	 * 
	 * Mongo mongo = new Mongo("localhost", 27017); DB db =
	 * mongo.getDB("BookStore");
	 * 
	 * 
	 * 
	 * 
	 * MongoClient mongoClient = new MongoClient( "localhost" , 27017 ); DB db =
	 * mongoClient.getDB( "BookStore");
	 * 
	 * 
	 * 
	 * collection = db.getCollection("user"); DBObject document = new
	 * BasicDBObject("id", 1113)
	 * 
	 * .append("userName", "abc"). append("email", "abc@gmail.com");
	 * 
	 * list.add(document); collection.insert(list);
	 * 
	 * return new ResponseEntity<>(null, HttpStatus.OK); } catch (Exception e) {
	 * return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); } }
	 */

}
