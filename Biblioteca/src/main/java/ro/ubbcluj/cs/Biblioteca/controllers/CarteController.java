package ro.ubbcluj.cs.Biblioteca.controllers;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ro.ubbcluj.cs.Biblioteca.model.Carte;
import ro.ubbcluj.cs.Biblioteca.services.ICarteService;
import ro.ubbcluj.cs.Biblioteca.services.IUserService;
import ro.ubbcluj.cs.Biblioteca.utils.Drepturi;

import com.google.gson.Gson;

@Controller
@Scope("request")
@RequestMapping("/books")
public class CarteController {

	@Autowired
	SessionContainer session;
	
	@Autowired
	ICarteService carteService;
	
	@Autowired
	IUserService userService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public @ResponseBody String addCarte(Map<String, Object> model,
			@RequestParam("add-carte-titlu") String titlu, 
			@RequestParam("add-carte-autori") String autori, 
			@RequestParam("add-carte-editura") String editura, 
			@RequestParam("add-carte-an") String an, 
			@RequestParam("add-carte-loc") String loc, 
			@RequestParam("add-carte-isbn") String isbn, 
			@RequestParam("add-carte-cota") String cota, 
			@RequestParam("add-carte-durata") String durata, 
			@RequestParam("add-carte-obs") String obs){
		
		if (session.getUserCrt() != null && session.getUserCrt().getDrepturi() == Drepturi.ADMIN) {
			// TODO: Refresh the list of books according to filter values.
			// TODO: validate inputs
			// TODO: exception handling

			try {
				Carte carte = new Carte(0, cota, titlu, autori, isbn, editura, loc, Integer.parseInt(an), obs, Integer.parseInt(durata));
				carte = carteService.addCarte(carte);
			} catch (Exception e) {
				e.printStackTrace();
				return "fail";
			}
		}
		
		return "success";
	}
	
	@RequestMapping(value="/get/all", method=RequestMethod.GET)
	public @ResponseBody String getBooks(Map<String, Object> model, 
			@RequestParam("input-filter-page") String pageNo,
			@RequestParam("input-filter-titlu") String titlu,
			@RequestParam("input-filter-autori") String autori,
			@RequestParam("input-filter-an") String an,
			@RequestParam("input-filter-editura") String editura,
			@RequestParam("input-filter-disponibil") String disponibil) {
		
		List<Carte> carti = carteService.getCartiByFilter(titlu, autori, an, editura, disponibil);
		
		int pageNr = Integer.parseInt(pageNo);
		int startIndex = 10 * (pageNr -1);
		int endIndex = 10 * pageNr;
		
		// TODO: JSON?
		Gson gson = new Gson();
		
		if (startIndex >= carti.size()) {
			return gson.toJson(new ArrayList<Carte>());
		} else if (endIndex >= carti.size()) {
			endIndex = carti.size();
		}
		
		// return the total number of books, and the books from the given page.
		// the total number of books is used to generate the navigation tab.
		List<Object> response = new ArrayList<Object>(Arrays.asList(new Object[]{carti.size(), carti.subList(startIndex, endIndex)}));
		return gson.toJson(response);
	}
	
	@RequestMapping(value="/import", method = RequestMethod.POST)
    public String uploadBooks(Map<String, Object> model, @RequestParam(value="books-file") MultipartFile file) {
		if (session.getUserCrt() != null && session.getUserCrt().getDrepturi() == Drepturi.ADMIN) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
				// TODO: validate the file
				parseFileAndSaveBooks(br);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		model.put("authenticated", session.getUserCrt() != null);
		model.put("user", session.getUserCrt());
		return "index";
	}

	private void parseFileAndSaveBooks(BufferedReader br) throws Exception {
		String line = br.readLine();
		while (line != null) {
			try {
				String[] items = line.split("\\|", -1);
				
				Gson gson = new Gson();
				System.out.println(gson.toJson(items));
				
				int an = 0;
				if (!items[6].trim().equals("")) {
					an = Integer.parseInt(items[6].trim());
				}
				Carte carte = new Carte(0, items[0], items[1], items[2], items[3], items[4], items[5], an, items[7], 1);
				carteService.addCarte(carte);
				line = br.readLine();
			} catch (Exception e) {
				String[] items = line.split("\\|", -1);
				Gson gson = new Gson();
				System.out.println(gson.toJson(items));
				throw e;
			}
		}
	}
}
