package ro.ubbcluj.cs.Biblioteca.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ro.ubbcluj.cs.Biblioteca.model.User;


public interface UserDao {
	
	/**
	 * 
	 * @return
	 * 
	 * Returns a list of all the users from the database.
	 */
	List<User> getAllUsers();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	User getUserById(String id);
	
	/**
	 * 
	 * @param user
	 */
	void deleteUser(User user);
	
	/**
	 * 
	 * @param user
	 */
	void addUser(User user);
	
	/**
	 * 
	 * @param user
	 */
	void updateUser(User user);

}
