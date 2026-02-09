package com.login.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.login.entity.UserEntity;
import com.login.repo.UserRepo;

public class MyUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity userEntity=userRepo.findByEmail(email);
		return new User(userEntity.getEmail(), userEntity.getPassword(), Collections.emptyList());
	}
	
	public boolean saveUser(UserEntity userEntity)
	{
		UserEntity entity=userRepo.save(userEntity);
		return entity.getId() != null;
	}

}
