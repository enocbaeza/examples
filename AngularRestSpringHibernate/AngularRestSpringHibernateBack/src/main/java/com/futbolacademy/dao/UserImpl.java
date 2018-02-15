package com.futbolacademy.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.futbolacademy.model.User;

@Repository
public class UserImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		Criteria criteria = getSession().createCriteria(User.class);
		return (List<User>) criteria.list();
	}

	public User findById(Integer id) {
		return (User) getSession().get(User.class, id);
	}

	public void saveOrUpdate(User user) {
		getSession().saveOrUpdate(user);
	}

	public void delete(Integer id) {
		User user = (User) getSession().get(User.class, id);
		getSession().delete(user);
	}
}
