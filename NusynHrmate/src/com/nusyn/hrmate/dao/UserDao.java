package com.nusyn.hrmate.dao;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;


import com.nusyn.hrmate.pojo.User;

@Repository
public class UserDao extends HibernateDaoSupport{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@PostConstruct
	public void init() {
		setSessionFactory(sessionFactory);
	}
	
	@Transactional
	public void save(User user) {
		sessionFactory.getCurrentSession().persist(user);
			
		//sessionFactory.getCurrentSession().save(user);
		
	}
}
