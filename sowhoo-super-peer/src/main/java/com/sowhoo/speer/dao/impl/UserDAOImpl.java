package com.sowhoo.speer.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sowhoo.speer.dao.UserDAO;
import com.sowhoo.speer.model.User;


@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
	
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	public User find(String email) {
		User user = null;
		String query = "SELECT * FROM sowhoouser WHERE uemail ='"+email+"'";
		try{
			user = (User)sessionFactory.getCurrentSession().
			createSQLQuery(query).addEntity(User.class).list().get(0);
		}catch(Exception ex){
			System.out.println(ex);
		};
		return user;
	}

}
