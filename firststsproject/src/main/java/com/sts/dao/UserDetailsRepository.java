package com.sts.dao;

import org.springframework.data.repository.CrudRepository;

import com.sts.entities.UserDetails;

public interface UserDetailsRepository extends CrudRepository<UserDetails,Integer>{
	  
	public UserDetails findById(int id);

}
