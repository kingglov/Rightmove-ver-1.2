package com.spring.mongo.resources;

import com.spring.mongo.daos.userDaos;
import com.spring.mongo.daos.verify_email;
import com.spring.mongo.model.Users;

import com.spring.mongo.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping
public class userResources {


    private UserRepository userRepository;

    public userResources(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<Users> getAll() {
        return userRepository.findAll();
    }

    @RequestMapping("home1")
    public ModelAndView home()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        return mv;
    }

    @RequestMapping("insert")
    public ModelAndView show(Users use1)
    {
        boolean te = false;
        Boolean b ;
        String testData[] = {
	    		  
         use1.getEmail()
        };
        verify_email ve = new verify_email();
         te =  ve.isAddressValid(use1.getEmail());
   
    ModelAndView mv = new ModelAndView();
                if (te==true) {
                     userDaos yu = new userDaos(userRepository);
                      b = yu.userDao(use1.getUser(),  use1.getPass(), use1.getEmail());              
                    mv.addObject("obj", use1);
                mv.setViewName("show");

                if (b == false){                  
                    String err = "Username already exist";
                    mv.addObject("obj", err);
                    mv.setViewName("home");
                } 
                }


                else{
                    String err = "Invalid Email id Please Enter a valid email ID";
                    mv.addObject("obj", err);
                    mv.setViewName("home");
                }
                
                        
         
              return mv;  
            }     
       
    
    @RequestMapping("login")
    public ModelAndView login(Users use1) {
       
        ModelAndView mv = new ModelAndView();
        if (use1.getUser().isEmpty() || use1.getPass().isEmpty()) {
            String err = "Please fill all fields";
            mv.addObject("obj", err);
            mv.setViewName("home");
        } else {
            
                userDaos ud = new userDaos(userRepository);

                String us = ud.login(use1.getUser(), use1.getPass());         
            if (us == "true") {
                          
                mv.addObject("obj", use1);
                mv.setViewName("show");
            }
           else if(us == "wp") {          
                String err = "Wrong Password";

                mv.addObject("obj", err);
                mv.setViewName("home");
           }
           else if(us == "false") { 
                String err = "Please provide valid Username";

                mv.addObject("obj", err);
                mv.setViewName("home");
           }
        }
        return mv;
    }
     

}