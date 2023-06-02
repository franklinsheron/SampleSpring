package com.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.model.User;
import com.springboot.repos.User1Repository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService 
{
private final User1Repository userrepository;
	
	public User save(@RequestBody User user)
	{
		return userrepository.save(user);
	}
	
	public List<User> getAllUser()
	{
		return userrepository.findAll();
	}
	
	public User updateUser(User user, Long id)
	{
		User existinguser = userrepository.findById(id).get(); 
		existinguser.setUname(user.getUname());
		return userrepository.save(existinguser);
	}
	
	public void deleteUser(Long id)
	{
		User existinguser = userrepository.findById(id).get(); 
		userrepository.delete(existinguser);
	}
	public User getUsersById(Long id)
	{
		return userrepository.findById(id).orElseThrow(()
		-> new RuntimeException("User found for the id "+id));	
	}
}
