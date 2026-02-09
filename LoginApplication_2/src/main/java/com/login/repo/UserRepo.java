package com.login.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer>{
	UserEntity findByEmail(String email);
}
