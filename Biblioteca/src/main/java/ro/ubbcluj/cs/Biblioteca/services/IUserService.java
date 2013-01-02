/**
 * 
 */
package ro.ubbcluj.cs.Biblioteca.services;

import java.util.List;

import ro.ubbcluj.cs.Biblioteca.model.User;

/**
 * @author lungociu
 *
 */
public interface IUserService {

	User logIn(String username, String password);
	
	List<User> getAllUsers();
	
	User getUserById(String id);
	
	void deleteUser(User user);
	
	void addUser(User user);
	
	void updateUser(User user);
}
