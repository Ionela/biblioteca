package ro.ubbcluj.cs.Biblioteca.services.impl;

import ro.ubbcluj.cs.Biblioteca.model.User;
import ro.ubbcluj.cs.Biblioteca.services.IUserService;
import ro.ubbcluj.cs.Biblioteca.utils.Drepturi;

public class UserServiceImpl implements IUserService{

	public User logIn(String username, String password) {
//		return null;
		if (username.equals("corneliu")) {
			return new User(1, "corneliu", "myPass", "Corneliu Lungociu", "mail", "telefon", "cluj", Drepturi.USER);
		} else if (username.equals("admin")) {
			return new User(1, "corneliu", "myPass", "Administrator", "mail", "telefon", "cluj", Drepturi.ADMIN);
		} else if (username.equals("bibliotecar")) {
			return new User(1, "bibliotecar", "myPass", "Bibliotecar", "mail", "telefon", "cluj", Drepturi.BIBLIOTECAR);
		}
		
		return null;
	}

}
