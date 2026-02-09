package com.ajinkya.dao;

import org.springframework.stereotype.Component;

@Component("userDAOImpl")
public class UserDAOImpl implements UserDAO{
	public UserDAOImpl() {
		System.out.println("UserDAOImpl.....");
	}
	@Override
	public String getUser() {
		System.out.println("First");
		return "Ajinkya";
	}
}
