package com.ajinkya.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ajinkya.entity.UserEntity;


@Repository
public interface UserRepo extends CrudRepository<UserEntity, Integer>{
	public UserEntity findByName(String name);
}
