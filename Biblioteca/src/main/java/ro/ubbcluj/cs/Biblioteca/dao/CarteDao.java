package ro.ubbcluj.cs.Biblioteca.dao;

import java.util.List;

import ro.ubbcluj.cs.Biblioteca.model.Carte;

public interface CarteDao {

	/**
	 * 
	 * @param carte The book to be saved in the DB.
	 * @return The book saved in the DB with the generated ID.
	 */
	public void addCarte(Carte carte);
	
	/**
	 * 
	 * @param cota
	 */
	public Carte getCarteByCota(String cota);
	
	public Carte getCarteById(String id);
	
	public List<Carte> getCartiByFilter(String titlu, String autori, String an, String editura, String disponibil);
	
	public List<Carte> getAllCarti();
}
