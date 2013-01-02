package ro.ubbcluj.cs.Biblioteca.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	public User getUserById(String id) {
		return userDao.getUserById(id);
	}
	
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}
	
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
}
