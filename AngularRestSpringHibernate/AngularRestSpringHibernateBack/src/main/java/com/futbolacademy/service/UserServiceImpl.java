package com.futbolacademy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futbolacademy.dao.UserDao;
import com.futbolacademy.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	UserDao userDao;

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findById(Integer id) {
		return userDao.findById(id);
	}

	public void saveOrUpdate(User user) {
		userDao.saveOrUpdate(user);
	}

	public void delete(Integer id) {
		userDao.delete(id);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
