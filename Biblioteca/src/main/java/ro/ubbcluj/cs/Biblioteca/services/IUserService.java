/**
 * 
 */
package ro.ubbcluj.cs.Biblioteca.services;

import ro.ubbcluj.cs.Biblioteca.model.User;

/**
 * @author lungociu
 *
 */
public interface IUserService {

	public User logIn(String username, String password);
}
