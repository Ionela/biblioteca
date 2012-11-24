package ro.ubbcluj.cs.Biblioteca.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ro.ubbcluj.cs.Biblioteca.services.ICarteService;
import ro.ubbcluj.cs.Biblioteca.services.IUserService;


@Controller
@Scope("request")
public class MainController {
	
	@Autowired
	SessionContainer session;
	
	@Autowired
	ICarteService carteService;
	
	@Autowired
	IUserService userService;
	
	@RequestMapping({"/","/home"})
	public String displayHomePage(Map<String, Object> model) {
		model.put("authenticated", session.getUserCrt() != null);
		model.put("user", session.getUserCrt());
		return "index";
	}
}
