package com.ajinkya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajinkya.entity.User;

public interface userRepository extends JpaRepository<User, Integer>{

}
