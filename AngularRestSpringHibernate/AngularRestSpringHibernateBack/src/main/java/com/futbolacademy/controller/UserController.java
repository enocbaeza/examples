package com.futbolacademy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.futbolacademy.model.User;
import com.futbolacademy.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/users", method=RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody List<User> findAll(){
		List<User> users = userService.findAll();
		return users;
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	public @ResponseBody User findUser(@PathVariable("id") Integer id) {
		User user = userService.findById(id);
		return user;
	}
	
	@RequestMapping(value="/users/add", method=RequestMethod.POST)
	public @ResponseBody User save(@RequestBody User user) {
		userService.saveOrUpdate(user);
		return user;
	}
	
	@RequestMapping(value="/users/update/{id}", method=RequestMethod.PUT)
	public @ResponseBody User update(@PathVariable("id") Integer id,@RequestBody User user) {
		user.setId(id);
		userService.saveOrUpdate(user);
		return user;
	}
	
	@RequestMapping(value="/users/delete/{id}", method=RequestMethod.DELETE)
	public @ResponseBody User update(@PathVariable("id") Integer id) {
		User user = userService.findById(id);
		userService.delete(id);
		return user;
	}
}
