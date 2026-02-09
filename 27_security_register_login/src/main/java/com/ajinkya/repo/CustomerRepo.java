package com.ajinkya.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ajinkya.entity.CustomerEnitity;
import java.util.List;


@Repository
public interface CustomerRepo extends CrudRepository<CustomerEnitity, Integer> {
	public CustomerEnitity findByCname(String cname);
}
