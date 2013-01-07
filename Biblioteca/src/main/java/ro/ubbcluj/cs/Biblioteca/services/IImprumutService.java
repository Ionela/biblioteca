package ro.ubbcluj.cs.Biblioteca.services;

import java.util.List;

import ro.ubbcluj.cs.Biblioteca.model.Imprumut;

public interface IImprumutService {
	
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
	public void deleteImprumut(Imprumut imprumut);

}
