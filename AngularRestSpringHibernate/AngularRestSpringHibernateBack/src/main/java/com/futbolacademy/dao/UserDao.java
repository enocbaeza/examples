package com.futbolacademy.dao;

import java.util.List;

import com.futbolacademy.model.User;

public interface UserDao {

	public List<User> findAll();
	
	public User findById(Integer id);
	
	public void saveOrUpdate(User user);
	
	public void delete(Integer id);
}
