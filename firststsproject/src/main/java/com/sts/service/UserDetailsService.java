package com.sts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.dao.UserDetailsRepository;
import com.sts.entities.UserDetails;

@Service
public class UserDetailsService {
	 
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	public List<UserDetails> getUserDetails()
	{
		List<UserDetails> findAll =(List<UserDetails>) userDetailsRepository.findAll();
		return findAll;
	}
	
	public UserDetails  saveUserDetails(UserDetails userDetails)
	{
		UserDetails save = userDetailsRepository.save(userDetails);
		return save;
		
		
	}
	
	public UserDetails updateUserDetails(int id)
	{
		UserDetails findById = userDetailsRepository.findById(id);
		return findById;
	}

}
