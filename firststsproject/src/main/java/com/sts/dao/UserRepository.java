package com.sts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sts.entities.User;

public interface UserRepository extends CrudRepository<User,Integer>{
	
	public List<User> findByName(String name);//find-introducer//ByName-critera
	public List<User> findByNameAndCity(String name,String city);
	public List<User> findByNameStartingWith(String prefix);
	public List<User> findByCityEndingWith(String suffix);
	public List<User> findByNameContaining(String words);
	public List<User> findByNameLike(String likePattern);
	
	public User findById(int id);
	
	@Query("Select u from User u where u.name=:n")
	public List<User> getAllUser(@Param("n") String name);
	
	@Query("Select u from User u where u.name=:n and u.city=:c")
	public List<User> getAllUserswithcity(@Param("n") String name, @Param("c") String city);
	
	@Query(value="Select * from User",nativeQuery = true)
	public List<User> getUsers();
	
	@Query("Select u.name from User u where u.name=:n")
	public List<String> getname(@Param("n") String name);
	
	
	

}
