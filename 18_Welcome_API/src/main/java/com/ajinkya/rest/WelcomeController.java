package com.ajinkya.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@Autowired
	private Environment environment;
	
	@GetMapping("/")
	public String getmsg() {
		return "Welcome Ajinkya This is Home Page";
	}
	
	@GetMapping("/welcome")
	public String demo() {
		
		String port=environment.getProperty("server.port");
		
		return "Ajinkya Dhavale("+port+")";
	}
}
