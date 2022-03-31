package com.sts.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sts.entities.UserDetails;
import com.sts.service.UserDetailsService;

@RestController
public class UserDetailsController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@GetMapping("/userdetails")
	public ResponseEntity<List<UserDetails>> getAllUserDetails()
	{
		List<UserDetails> userDetails = userDetailsService.getUserDetails();
		if (userDetails==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(userDetails);
	}

	@PostMapping("/userdetails")
	public ResponseEntity<UserDetails> getAllUserDetails(@RequestBody UserDetails userDetails)
	{
		UserDetails saveUserDetails = userDetailsService.saveUserDetails(userDetails);
		if (saveUserDetails==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(saveUserDetails);
	}
	
	@PutMapping("/userdetails/{id}")
	public ResponseEntity<UserDetails> updateAllUserDetails(@PathVariable("id") int id,  @RequestBody UserDetails userDetails)
	{
		 UserDetails saveUserDetails = userDetailsService.updateUserDetails(id);
		 saveUserDetails.setId(id);
		 saveUserDetails.setName(userDetails.getName());
		 saveUserDetails.setAccount(userDetails.getAccount());
		 UserDetails saveUserDetails2 = userDetailsService.saveUserDetails(saveUserDetails);
		 
		if (saveUserDetails2==null)
		{
			System.out.println(saveUserDetails2);
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		System.out.println(saveUserDetails2);
		return ResponseEntity.status(HttpStatus.FOUND).body(saveUserDetails);
	}
	
}
