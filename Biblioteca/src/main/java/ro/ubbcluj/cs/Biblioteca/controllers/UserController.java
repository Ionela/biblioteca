package ro.ubbcluj.cs.Biblioteca.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ro.ubbcluj.cs.Biblioteca.model.Carte;
import ro.ubbcluj.cs.Biblioteca.model.User;
import ro.ubbcluj.cs.Biblioteca.services.ICarteService;
import ro.ubbcluj.cs.Biblioteca.services.IUserService;
import ro.ubbcluj.cs.Biblioteca.utils.Drepturi;

import com.google.gson.Gson;

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
	
	@RequestMapping(value="/get/all", method=RequestMethod.GET)
	public @ResponseBody String getUsers(){
		if (session.getUserCrt() != null && session.getUserCrt().getDrepturi() >=1) {
			List<User> useri = userService.getAllUsers();
			Gson gson = new Gson();
			return gson.toJson(useri);
		}
		return null;
	}
	
	@RequestMapping(value="/user/{user-id}", method=RequestMethod.GET)
	public @ResponseBody String getUserById(@PathVariable("user-id") String userId){
		if (session.getUserCrt() != null && session.getUserCrt().getDrepturi() >=1) {
			User user = userService.getUserById(userId);
			Gson gson = new Gson();
			return gson.toJson(user);
		}
		return null;
	}
	
	@RequestMapping(value="/user/{user-id}", method=RequestMethod.DELETE)
	public @ResponseBody String deleteUser(@PathVariable("user-id") String userId){
		if (session.getUserCrt() != null && session.getUserCrt().getDrepturi() >=1) {
			try{
				userService.deleteUser(new User(Integer.parseInt(userId), "", "", "", "", "", "", 0));
			} catch (Exception e) {
				e.printStackTrace();
				return "failed";
			}
		}
		return "success";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public @ResponseBody String addUser(Map<String, Object> model,
			@RequestParam("add-user-username") String username, 
			@RequestParam("add-user-password") String password, 
			@RequestParam("add-user-nume") String nume, 
			@RequestParam("add-user-email") String email, 
			@RequestParam("add-user-telefon") String telefon, 
			@RequestParam("add-user-adresa") String adresa, 
			@RequestParam("add-user-drepturi") String drepturi){
		
		if (session.getUserCrt() != null && session.getUserCrt().getDrepturi() == Drepturi.ADMIN) {
			// TODO: Refresh the list of books according to filter values.
			// TODO: validate inputs
			// TODO: exception handling

			try {
				User user = new User(0, username, password, nume, email, telefon, adresa, Integer.parseInt(drepturi));
				userService.addUser(user);
			} catch (Exception e) {
				e.printStackTrace();
				return "fail";
			}
		}
		
		return "success";
	}
	
	@RequestMapping(value="/user/{user-id}", method=RequestMethod.POST)
	public @ResponseBody String updateUser(Map<String, Object> model,
			@PathVariable("user-id") String idUser,
			@RequestParam("add-user-username") String username, 
			@RequestParam("add-user-password") String password, 
			@RequestParam("add-user-nume") String nume, 
			@RequestParam("add-user-email") String email, 
			@RequestParam("add-user-telefon") String telefon, 
			@RequestParam("add-user-adresa") String adresa, 
			@RequestParam("add-user-drepturi") String drepturi){
		
		if (session.getUserCrt() != null && session.getUserCrt().getDrepturi() == Drepturi.ADMIN) {
			// TODO: Refresh the list of books according to filter values.
			// TODO: validate inputs
			// TODO: exception handling

			try {
				User user = new User(Integer.parseInt(idUser), username, password, nume, email, telefon, adresa, Integer.parseInt(drepturi));
				userService.updateUser(user);
			} catch (Exception e) {
				e.printStackTrace();
				return "fail";
			}
		}
		
		return "success";
	}

}
