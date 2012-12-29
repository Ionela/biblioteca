package ro.ubbcluj.cs.Biblioteca.controllers;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ro.ubbcluj.cs.Biblioteca.model.Carte;
import ro.ubbcluj.cs.Biblioteca.model.User;

@Component
@Scope("session")
public class SessionContainer {
	private boolean authenticated = false;
	private User userCrt = null;;

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public User getUserCrt() {
		return userCrt;
	}

	public void setUserCrt(User userCrt) {
		this.userCrt = userCrt;
	}
}
