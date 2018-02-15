package com.futbolacademy.service;

import java.util.List;

import com.futbolacademy.model.User;

public interface UserService {

	public List<User> findAll();
	
	public User findById(Integer id);
	
	public void saveOrUpdate(User user);
	
	public void delete(Integer id);
}
