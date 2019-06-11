package com.spring.mongo.daos;

import java.util.List;
import java.util.Optional;
import com.spring.mongo.model.Users;
import com.spring.mongo.repository.UserRepository;


public class userDaos {

    
	private UserRepository userRepository;

    public userDaos(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Boolean userDao(String user, String pass ,String email) {

        Optional <Users> u = userRepository.findById(user);
    
              if (u.isPresent()) {
                   return false;
              }
        userRepository.save(new Users(user, pass,email));
        return true;
    }
    
    public String login(String user, String pass) {
        String use = null , pas = null;
        Optional <Users> u = userRepository.findById(user);
             use =  u.get().getUser();
             pas =  u.get().getPass();

            // List <Users> ss = userRepository.findByEmail(user);
            
            // for (Users var : ss) {
            //       use =  var.getUser();
            //       pas =  var.getPass();
            //               }
              if (use.equals(user)&& pas.equals(pass) ){
                    
                return "true";
              }
              else if (use.equals(user)&& !pas.equals(pass)) {
                return "wp";
              }
            
             
        return "false";
        
     } 
     
 }
    








