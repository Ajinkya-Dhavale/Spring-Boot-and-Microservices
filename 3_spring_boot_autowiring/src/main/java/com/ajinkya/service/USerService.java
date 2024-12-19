package com.ajinkya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ajinkya.dao.UserDAO;

@Component
public class USerService {
	UserDAO dao;
	public USerService() {
		System.out.println("UserService....");
	}
	
	@Autowired
//	@Qualifier("userDAOImpl") for byName
	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

	public void getUserName(int id)
	{
		System.out.println(dao.getUser());
	}
}
