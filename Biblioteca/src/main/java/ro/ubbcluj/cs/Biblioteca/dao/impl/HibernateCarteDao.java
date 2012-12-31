package ro.ubbcluj.cs.Biblioteca.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

import ro.ubbcluj.cs.Biblioteca.dao.CarteDao;
import ro.ubbcluj.cs.Biblioteca.model.Carte;

@Repository
public class HibernateCarteDao implements CarteDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public void addCarte(Carte carte) {
		currentSession().save(carte);
	}

	@Transactional
	public Carte getCarteByCota(String cota) {
		List<Carte> carti = currentSession().createQuery("from Carte where cota='" + cota + "'").list();
//		for (Carte carte : carti) {
//			if (carte.getCota().equals(cota)) {
//				return carte;
//			}
//		}
		
		if (carti.isEmpty()) {
			return null;
		} else {
			return carti.get(0);
		}
		
	}

	@Transactional
	public List<Carte> getCartiByFilter(String titlu, String autori, String an, String editura, String disponibil) {
		// TODO Filter Books
		List<Carte> carti = currentSession().createQuery("from Carte where titlu like '%"+ titlu +"%' and autori like '%"+ autori +"%'" + 
		" and anAparitie like '%"+ an +"%' " + 
		" and editura like '%"+ editura +"%'").list();

		return carti;
	}
	
	@Transactional
	public List<Carte> getAllCarti() {
		List<Carte> carti = currentSession().createQuery("from Carte").list();
		return carti;
	}
	
	
}
