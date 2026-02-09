package com.ajinkya.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {

@GetMapping("/msg")
public String getMethodName() {
    return "Welcome to Spring Basic HTTP security";
}

@GetMapping("/contact")
public String getContactPage() {
	return "Contact";
}
}
