package ro.ubbcluj.cs.Biblioteca.dao;

import java.util.List;

import ro.ubbcluj.cs.Biblioteca.model.Imprumut;

public interface ImprumutDao {

	/**
	 * 
	 * @param userId
	 * @return
	 */
	public List<Imprumut> getImprumuturiByUser(String userId);
	
	/**
	 * 
	 * @param imprumut
	 */
	public void addImprumut(Imprumut imprumut);
	
	/**
	 * 
	 * @param imprumut
	 */
	public void removeImprumut(Imprumut imprumut);
}
