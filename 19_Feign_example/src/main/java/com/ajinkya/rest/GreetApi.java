package com.ajinkya.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajinkya.client.WelcomeApiClient;

@RestController
public class GreetApi {
	
	@Autowired
	private WelcomeApiClient client;
	
	@GetMapping("/greet")
	public String getString(Model model)
	{
		String string=client.invokeWelcomeAPI();
		return "Welcome Ajinkya"+string;
	}	
}
