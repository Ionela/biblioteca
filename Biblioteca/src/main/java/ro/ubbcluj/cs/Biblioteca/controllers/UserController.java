package ro.ubbcluj.cs.Biblioteca.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ro.ubbcluj.cs.Biblioteca.model.User;
import ro.ubbcluj.cs.Biblioteca.services.ICarteService;
import ro.ubbcluj.cs.Biblioteca.services.IUserService;

@Controller
@Scope("request")
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	SessionContainer session;
	
	@Autowired
	ICarteService carteService;
	
	@Autowired
	IUserService userService;
	
	@RequestMapping(value="/logIn", method=RequestMethod.POST)
	public String logIn(Map<String, Object> model, @RequestParam("userName") String userName, @RequestParam("password") String password){
		
		User userCrt = userService.logIn(userName, password);
		session.setUserCrt(userCrt);
		session.setAuthenticated(userCrt!=null);
		
		model.put("authenticated", session.getUserCrt() != null);
		model.put("user", session.getUserCrt());
		
		return "index";
	}
	
	@RequestMapping(value="/logOut", method=RequestMethod.POST)
	public String logOut(Map<String, Object> model){
		
		session.setUserCrt(null);
		session.setAuthenticated(false);
		
		model.put("authenticated", session.getUserCrt() != null);
		model.put("user", session.getUserCrt());
		
		return "index";
	}

}
