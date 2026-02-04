package com.ajinkya.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class WelcomeRestController {
	@GetMapping("/")
	public String welcomeMsg() {
		return "<h1>Welcome to my Application</h1>";
	}
	
}
