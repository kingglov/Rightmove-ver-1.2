package com.spring.mongo.repository;

import java.util.List;

import com.spring.mongo.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository  extends MongoRepository<Users, String > {

	List <Users> findByEmail(String email);
}
