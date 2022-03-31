package com.sts.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sts.dao.UserRepository;
import com.sts.entities.User;
import com.sts.service.Userservice;

@RestController

public class TestController  {
	
	@Autowired
	Userservice  userService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> handleTest()
	{
		List<User> list = (List<User>)userService.findAllUser();
		
		if(list.size()==0)
		{
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else
			//return ResponseEntity.status(HttpStatus.FOUND).body(list);
			return ResponseEntity.of(Optional.of(list));
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<User> SingleUser(@PathVariable("id") int id)
	{
		User findById = userService.getUserById(id);
		if (findById==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		//return ResponseEntity.of(findById);
		return ResponseEntity.status(HttpStatus.FOUND).body(findById);
		
	}
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user)
	{
		User save=userService.saveUser(user);
		if(save ==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(save);
		
		
		
	}
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User userput)
	{
		User findById = (User) userService.getUserById(id);
		
		findById.setCity(userput.getCity());
		findById.setName(userput.getName());
		findById.setStatus(userput.getStatus());
		findById.setId(id);
		User saveUser = userService.saveUser(findById);
		if(saveUser==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		 userService.getUser();
		return ResponseEntity.status(HttpStatus.FOUND).body(saveUser);
		
	}

}
