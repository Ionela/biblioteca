package ro.ubbcluj.cs.Biblioteca.dao;

import java.util.List;

import ro.ubbcluj.cs.Biblioteca.model.User;


public interface UserDao {
	
	/**
	 * 
	 * @return
	 * 
	 * Returns a list of all the users from the database.
	 */
	List<User> getAllUsers();

}
