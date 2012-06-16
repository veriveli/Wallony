package com.wallony.message.dao;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class HibernateBaseDao extends HibernateDaoSupport {
	
	@Autowired
	@Qualifier("sessionFactory")
	public SessionFactory sf;

	@PostConstruct
	void init() {
		setSessionFactory(sf);
	}
}
