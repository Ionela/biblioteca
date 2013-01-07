package ro.ubbcluj.cs.Biblioteca.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ro.ubbcluj.cs.Biblioteca.dao.ImprumutDao;
import ro.ubbcluj.cs.Biblioteca.model.Imprumut;
import ro.ubbcluj.cs.Biblioteca.services.IImprumutService;

public class ImprumutServiceImpl implements IImprumutService{

	@Autowired
	ImprumutDao imprumutDao;
	
	public List<Imprumut> getImprumuturiByUser(String userId) {
		return imprumutDao.getImprumuturiByUser(userId);
	}

	public void addImprumut(Imprumut imprumut) {
		imprumutDao.addImprumut(imprumut);
	}

	public void deleteImprumut(Imprumut imprumut) {
		imprumutDao.removeImprumut(imprumut);
	}

}
