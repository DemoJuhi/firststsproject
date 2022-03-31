package com.sts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.dao.UserRepository;
import com.sts.entities.User;

@Service
public class Userservice {
	
	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user)
	{
		User save = userRepository.save(user);
		return save;
	}
	
	public List<User> getUser()
	{
		List<User> list=(List<User>)userRepository.findAll();
		return list;
	}
	
	public User getUserById(int id)
	{
		User findById = (User) userRepository.findById(id);
		
		return findById;
		
	}
	public List<User> findAllUser()
	{
		List<User> list=(List<User>)userRepository.findAll();
		return list;
	}
}
