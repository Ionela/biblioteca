package ro.ubbcluj.cs.Biblioteca.controllers;

import java.util.Calendar;
import java.util.Date;
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
import ro.ubbcluj.cs.Biblioteca.model.Imprumut;
import ro.ubbcluj.cs.Biblioteca.model.User;
import ro.ubbcluj.cs.Biblioteca.services.ICarteService;
import ro.ubbcluj.cs.Biblioteca.services.IImprumutService;
import ro.ubbcluj.cs.Biblioteca.services.IUserService;
import ro.ubbcluj.cs.Biblioteca.utils.Drepturi;

import com.google.gson.Gson;

@Controller
@Scope("request")
public class ImprumutController {
	
	@Autowired
	SessionContainer session;
	
	@Autowired
	ICarteService carteService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IImprumutService imprumutService;
	
	@RequestMapping(value="/users/{user-id}/imprumuturi", method=RequestMethod.GET)
	public @ResponseBody String getImprumuturi(@PathVariable("user-id") String userId){
		
		if (session.getUserCrt() != null) {
			Gson gson = new Gson();
			return gson.toJson(imprumutService.getImprumuturiByUser(userId));
		}
		
		return null;
	}
	
	@RequestMapping(value="/users/{user-id}/imprumuturi/add", method=RequestMethod.POST)
	public @ResponseBody String addImprumut(@PathVariable("user-id") String userId,
			@RequestParam("book-id") String bookId){
		
		if (session.getUserCrt() != null && session.getUserCrt().getDrepturi() == Drepturi.BIBLIOTECAR) {
			try {
				User user = new User(Integer.parseInt(userId), "", "", "", "", "", "", 0);
				Carte carte = carteService.getCarteById(bookId);
				
				int amount = 7 * carte.getDurataImprumut();
				
				Calendar currentCalendarDate = Calendar.getInstance();
				Date dinData = currentCalendarDate.getTime();
				currentCalendarDate.add(Calendar.DATE, amount);
				Date panaInData = currentCalendarDate.getTime();
				
				Imprumut imprumut = new Imprumut(0, carte, user, dinData, panaInData);
				imprumutService.addImprumut(imprumut);
				return "success";
			} catch (Exception e) {
				e.printStackTrace();
				return "failure";
			}
		}
		
		return "failure";
	}
	
	@RequestMapping(value="/users/{user-id}/imprumuturi/{imprumut-id}", method=RequestMethod.DELETE)
	public @ResponseBody String returnImprumut(@PathVariable("user-id") String userId,
			@PathVariable("imprumut-id") String imprumutId){
		
		if (session.getUserCrt() != null) {
			try {
				User user = new User(Integer.parseInt(userId), "", "", "", "", "", "", 0);
			
				Carte carte = new Carte(0, "", "", "", "", "", "", 0, "", 0);
				Imprumut imprumut = new Imprumut(Integer.parseInt(imprumutId), carte, user, new Date(), new Date());
				imprumutService.deleteImprumut(imprumut);
				return "success";
			} catch (Exception e) {
				e.printStackTrace();
				return "failure";
			}
		}
		
		return "failure";
	}
}
