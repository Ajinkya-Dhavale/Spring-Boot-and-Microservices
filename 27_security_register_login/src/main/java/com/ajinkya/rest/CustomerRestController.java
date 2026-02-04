package com.ajinkya.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajinkya.entity.CustomerEnitity;
import com.ajinkya.repo.CustomerRepo;
import com.ajinkya.service.MyUserDetailService;

@RestController
public class CustomerRestController {
    @Autowired
    private CustomerRepo repo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AuthenticationManager manager;

    @PostMapping("/register")
    public String registerUser(@RequestBody CustomerEnitity c) {
        // Validate password before encoding
        if (c.getCpassword() == null || c.getCpassword().isEmpty()) {
            return "Password cannot be null or empty";
        }

        // Encode the password and save the user
        c.setCpassword(passwordEncoder.encode(c.getCpassword()));
        repo.save(c);

        return "User registered successfully";
    }
    
    @GetMapping("/user")
    public Iterable<CustomerEnitity> getCustomerEnitities()
    {
    	return repo.findAll();
    }
    
    
    
    //login logic
    @PostMapping("/login")
    public ResponseEntity<String> registerUser1(@RequestBody CustomerEnitity c) {
    	UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(c.getCname(), c.getCpassword());
    	
    	try {
    		Authentication authentication=manager.authenticate(token);
        	if(authentication.isAuthenticated())
        	{
        		return new ResponseEntity<String>("welcome",HttpStatus.OK);
        	}
        	
		} catch (Exception e) {
			
		}
    	return new ResponseEntity<String>("Invalid Crendential",HttpStatus.BAD_REQUEST);
    	
    }
    
}
