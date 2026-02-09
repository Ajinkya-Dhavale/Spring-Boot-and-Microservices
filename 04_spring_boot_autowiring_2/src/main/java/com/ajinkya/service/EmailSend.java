package com.ajinkya.service;

import org.springframework.stereotype.Component;

@Component
public class EmailSend {
	public Boolean sendEmail(String to,String sub,String body) {
		System.out.println("Email Send Successfully");
		return true;
	}
}
