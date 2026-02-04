package com.ajinkya.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ajinkya.entity.CustomerEnitity;
import com.ajinkya.repo.CustomerRepo;

@Service
public class MyUserDetailService implements UserDetailsService{
	
	@Autowired
	private CustomerRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomerEnitity customerEnitity=repo.findByCname(username);
		
		return new User(customerEnitity.getCname(), customerEnitity.getCpassword(), Collections.emptyList());
	}

}
