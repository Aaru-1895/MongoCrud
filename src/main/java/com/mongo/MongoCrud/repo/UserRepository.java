package com.mongo.MongoCrud.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.MongoCrud.model.User;

public interface UserRepository extends MongoRepository<User, Integer>{

}
