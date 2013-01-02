package ro.ubbcluj.cs.Biblioteca.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="/book/{book-id}", method=RequestMethod.POST)
	public @ResponseBody String updateBook(Map<String, Object> model,
			@PathVariable("book-id") String bookId,
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
				Carte carte = new Carte(Integer.parseInt(bookId), cota, titlu, autori, isbn, editura, loc, Integer.parseInt(an), obs, Integer.parseInt(durata));
				carte = carteService.updateCarte(carte);
			} catch (Exception e) {
				e.printStackTrace();
				return "fail";
			}
		}
		
		return "success";
	}
	
	@RequestMapping(value="/book/{book-id}", method=RequestMethod.DELETE)
	public @ResponseBody String deleteBook(Map<String, Object> model, @PathVariable("book-id") String bookId){
		
		if (session.getUserCrt() != null && session.getUserCrt().getDrepturi() == Drepturi.ADMIN) {
			// TODO: Refresh the list of books according to filter values.
			// TODO: validate inputs
			// TODO: exception handling

			try {
				Carte carte = new Carte(Integer.parseInt(bookId), "", "", "", "", "", "", 0, "", 0);
				carteService.deleteCarte(carte);
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
		List<Carte> cartiFiltrate = getSpecificPage(pageNo, carti);
		
		// return the total number of books, and the books from the given page.
		// the total number of books is used to generate the navigation tab.
		List<Object> response = new ArrayList<Object>(Arrays.asList(new Object[]{carti.size(), cartiFiltrate}));

		Gson gson = new Gson();
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
	
	@RequestMapping(value="/export", method=RequestMethod.GET)
	public void exportBooks(Map<String, Object> model, 
			@RequestParam("input-filter-page") String pageNo,
			@RequestParam("input-filter-titlu") String titlu,
			@RequestParam("input-filter-autori") String autori,
			@RequestParam("input-filter-an") String an,
			@RequestParam("input-filter-editura") String editura,
			@RequestParam("input-filter-disponibil") String disponibil,
			HttpServletResponse servletResponse,
			HttpServletRequest servletRequest) {
		
		try {
			List<Carte> carti = carteService.getCartiByFilter(titlu, autori, an, editura, disponibil);
//			carti = getSpecificPage(pageNo, carti);
			
			servletResponse.setContentType("application/pdf");
			servletResponse.setHeader("Content-Disposition", "attachment;filename=raport.pdf");

			String raportPath = servletRequest.getSession().getServletContext().getRealPath("/WEB-INF/classes/raportBiblioteca2.jrxml");
			InputStream is = generatePDF(raportPath, carti);
			IOUtils.copy(is, servletResponse.getOutputStream());
			servletResponse.flushBuffer();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/book/{book-id}", method=RequestMethod.GET)
	public @ResponseBody String getBookById(Map<String, Object> model, @PathVariable("book-id") String bookId) {
		Carte carte = carteService.getCarteById(bookId);
		Gson gson = new Gson();
		return gson.toJson(carte);
	}
	
	private InputStream generatePDF(String raportPath, List<Carte> dataSource) throws JRException, FileNotFoundException {
		Map<String, Object> parameters = new HashMap<String, Object>();
//		parameters.put("codProdus", codProdus);
//		parameters.put("numeProdus", numeProdus);
//		parameters.put("client", client);

		JRBeanCollectionDataSource jRBeanArrayDataSource = new JRBeanCollectionDataSource(dataSource);
		
		JasperDesign design = JRXmlLoader.load(raportPath);
		JasperReport report = JasperCompileManager.compileReport(design);
		JasperPrint print = JasperFillManager.fillReport(report, parameters, jRBeanArrayDataSource);
		JRExporter exporter = new JRPdfExporter();

		exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "c:/raport.pdf");
		exporter.exportReport();
		
		return new FileInputStream("c:/raport.pdf");
	}
	

	private List<Carte> getSpecificPage(String pageNo, List<Carte> carti) {
		int pageNr = Integer.parseInt(pageNo);
		int startIndex = 10 * (pageNr -1);
		int endIndex = 10 * pageNr;
		
		List<Carte> cartiFiltrate = new ArrayList<Carte>();
		if (startIndex < carti.size()) {
			if (endIndex >= carti.size()) {
				endIndex = carti.size();
			}
			
			cartiFiltrate = carti.subList(startIndex, endIndex);
		}
		
		return cartiFiltrate;
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
