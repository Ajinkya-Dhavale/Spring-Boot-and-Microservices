package com.ajinkya.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ajinkya.entity.UserEntity;
import com.ajinkya.repo.UserRepo;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity user =repo.findByName(username);
		
		return new User(user.getName(), user.getPassword(), Collections.emptyList());
	}
	
	public boolean saveUser(UserEntity user)
	{
		UserEntity userEntity=repo.save(user);
		
		return userEntity.getUserId()!=null;
	}

}
