package com.login.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.binding.AppRequest;
import com.login.entity.UserEntity;
import com.login.service.MyUserDetailService;

@RestController
@RequestMapping("/api")
public class UserRest {

	@Autowired
	private MyUserDetailService service;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authmanager;
	
	@PostMapping("/register")
	public String registerUser(UserEntity userEntity)
	{
		String passwordEncrypt=passwordEncoder.encode(userEntity.getPassword());
		
		userEntity.setPassword(passwordEncrypt);
		
		boolean saveUser = service.saveUser(userEntity);
		
		if(saveUser)
			return "User Register Successfully";
		else
			return "User Register Failed";
	}
	
	
	@PostMapping("/login")
	public String loginUser(AppRequest request)
	{
		UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
	
		try {
			Authentication authenticate = authmanager.authenticate(token);
			
			if(authenticate.isAuthenticated())
			{
				
				//generate a token
				return "Login Successfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Login Failed";
	}
	
	
}
