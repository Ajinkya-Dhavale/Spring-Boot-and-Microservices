package com.ajinkya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ajinkya.dao.UserDAO;

@Component
public class UserService {
	private UserDAO dao;
	private PwdService pwdService;
	private EmailSend emailSend;
	
	
	//no need @Autowired Annotation because this class only one parameterize constructor
	public UserService(UserDAO dao,PwdService service,EmailSend email)
	{
		this.dao=dao;
		this.pwdService=service;
		this.emailSend=email;
	}
	
	/*
	@Autowired
	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

	@Autowired
	public void setPwdService(PwdService pwdService) {
		this.pwdService = pwdService;
	}

	@Autowired
	public void setEmailSend(EmailSend emailSend) {
		this.emailSend = emailSend;
	}
	*/
	

	public void registerUser(String name,String email,String pass)
	{
		String encryptPwd =pwdService.encryptPwd(pass);
		Boolean isSend=dao.saveUser(name, email, encryptPwd);
		
		if(isSend)
		{
			System.out.println("Resister User Successfully.......");
			emailSend.sendEmail(email, "Successfully Send", "Nothing");
		}
	}
}
