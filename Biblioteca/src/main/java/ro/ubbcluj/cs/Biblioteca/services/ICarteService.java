package ro.ubbcluj.cs.Biblioteca.services;

import java.util.List;

import ro.ubbcluj.cs.Biblioteca.model.Carte;

public interface ICarteService {
	
	/**
	 * Tries to add a new book to the DB
	 * @param carte The book to be added
	 * @return The new book saved in the DB
	 */
	public Carte addCarte(Carte carte);

	/**
	 * 
	 * @param titlu
	 * @param autori
	 * @param an
	 * @param editura
	 * @param disponibil
	 * @return
	 */
	public List<Carte> getCartiByFilter(String titlu, String autori, String an, String editura, String disponibil);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Carte getCarteById(String id);
	
	/**
	 * 
	 * @param carte
	 * @return
	 */
	public Carte updateCarte(Carte carte);
	
	/**
	 * 
	 * @param carte
	 */
	public void deleteCarte(Carte carte);
}
