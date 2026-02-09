package com.ajinkya.service;

import org.springframework.stereotype.Component;

@Component
public class PwdService {
	public String encryptPwd(String pass)
	{
		System.out.println("Password Encrypt Successfully");
		return pass;
	}
}
