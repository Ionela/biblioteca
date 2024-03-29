package ro.ubbcluj.cs.Biblioteca.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ro.ubbcluj.cs.Biblioteca.dao.CarteDao;
import ro.ubbcluj.cs.Biblioteca.model.Carte;
import ro.ubbcluj.cs.Biblioteca.services.ICarteService;

public class CarteServiceImpl implements ICarteService{

	@Autowired
	CarteDao carteDao;
	
	public Carte addCarte(Carte carte) {
		carteDao.addCarte(carte);
		return carteDao.getCarteByCota(carte.getCota());
	}
	
	public Carte updateCarte(Carte carte) {
		carteDao.updateCarte(carte);
		return carteDao.getCarteById(carte.getIdCarte() + "");
	}
	
	public void deleteCarte(Carte carte) {
		//TODO: check if the book is borrowed.
		carteDao.deleteCarte(carte);
	}
	
	public List<Carte> getCartiByFilter(String titlu, String autori, String an, String editura, String disponibil) {
		//TODO: filter books
		return carteDao.getCartiByFilter(titlu, autori, an, editura, disponibil);
	}
	
	public Carte getCarteById(String id) {
		return carteDao.getCarteById(id);
	}
}
