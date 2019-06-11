package com.spring.mongo.repository;

import com.spring.mongo.model.properties;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * propertiesrepo
 */
public interface propertiesrepo extends MongoRepository<properties,String>{

    
}