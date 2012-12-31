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
	
	public List<Carte> getCartiByFilter(String titlu, String autori, String an, String editura, String disponibil) {
		//TODO: filter books
		return carteDao.getCartiByFilter(titlu, autori, an, editura, disponibil);
	}
}
