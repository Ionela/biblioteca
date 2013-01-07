package ro.ubbcluj.cs.Biblioteca.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ro.ubbcluj.cs.Biblioteca.dao.ImprumutDao;
import ro.ubbcluj.cs.Biblioteca.model.Carte;
import ro.ubbcluj.cs.Biblioteca.model.Imprumut;

@Repository
public class HibernateImprumutDao implements ImprumutDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public List<Imprumut> getImprumuturiByUser(String userId) {
		return currentSession().createQuery("from Imprumut where idUser='" + userId+ "'").list();
	}

	@Transactional
	public void addImprumut(Imprumut imprumut) {
		currentSession().save(imprumut);
		
	}

	@Transactional
	public void removeImprumut(Imprumut imprumut) {
		currentSession().delete(imprumut);
	}
}
