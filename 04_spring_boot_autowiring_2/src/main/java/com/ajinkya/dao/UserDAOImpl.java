package com.ajinkya.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDAOImpl implements UserDAO{

	@Override
	public boolean saveUser(String name, String email, String pass) {
		System.out.println("User Inserted.....");
		return true;
	}

}
