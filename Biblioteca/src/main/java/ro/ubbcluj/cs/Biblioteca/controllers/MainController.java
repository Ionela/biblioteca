package ro.ubbcluj.cs.Biblioteca.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Scope("request")
public class MainController {
	
	@Autowired
	SessionContainer session;
	
	@RequestMapping({"/",""})
	public String displayHomePage(Map<String, Object> model) {
		model.put("authenticated", session.isAuthenticated());
		return "index";
	}
}
