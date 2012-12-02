package ro.ubbcluj.cs.Biblioteca.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ro.ubbcluj.cs.Biblioteca.dao.UserDao;
import ro.ubbcluj.cs.Biblioteca.model.User;

@Repository
public class HibernateUserDao implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public List<User> getAllUsers() {
		return currentSession().createQuery("from User").list();
	}
	
}
