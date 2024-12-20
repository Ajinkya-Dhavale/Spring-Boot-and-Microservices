package com.ajinkya.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajinkya.entity.UserEntity;
import com.ajinkya.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo repo;
	
	public List<UserEntity> getUsers()
	{
		List<UserEntity> list=repo.findAll();
		return list;
	}
	
	public boolean saveUser(UserEntity u)
	{
		if(repo.save(u)!=null)
			return true;
		return false;
	}
	 public boolean deleteUser(Integer id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false; // User does not exist
    }

	 public boolean updateUser(Integer id, UserEntity updateRequest) {
	        Optional<UserEntity> optionalUser = repo.findById(id);
	        if (optionalUser.isPresent()) {
	            UserEntity user = optionalUser.get();
	            if (updateRequest.getUserName() != null) {
	                user.setUserName(updateRequest.getUserName());
	            }
	            if (updateRequest.getUserAge() != null) {
	                user.setUserAge(updateRequest.getUserAge());
	            }
	            repo.save(user);
	            return true;
	        }
	        return false;
	    }
	 
}
