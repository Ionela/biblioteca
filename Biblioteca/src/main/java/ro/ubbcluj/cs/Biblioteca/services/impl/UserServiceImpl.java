package ro.ubbcluj.cs.Biblioteca.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ro.ubbcluj.cs.Biblioteca.dao.UserDao;
import ro.ubbcluj.cs.Biblioteca.model.User;
import ro.ubbcluj.cs.Biblioteca.services.IUserService;

public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserDao userDao;

	public User logIn(String username, String password) {
		List<User> users = userDao.getAllUsers();
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)){
				return user;
			}
		}
		return null;
	}

}
