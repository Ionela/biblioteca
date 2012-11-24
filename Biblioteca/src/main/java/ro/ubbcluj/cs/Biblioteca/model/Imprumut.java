package ro.ubbcluj.cs.Biblioteca.model;

import java.util.Date;

public class Imprumut {
	private int idImprumut;
	private Carte carte;
	private User user;
	private Date dinData;
	private Date panaInData;
	
	public Imprumut(int idImprumut, Carte carte, User user, Date dinData) {
		this.idImprumut = idImprumut;
		this.carte = carte;
		this.user = user;
		this.dinData = dinData;
	}

	public int getIdImprumut() {
		return idImprumut;
	}

	public void setIdImprumut(int idImprumut) {
		this.idImprumut = idImprumut;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDinData() {
		return dinData;
	}

	public void setDinData(Date dinData) {
		this.dinData = dinData;
	}

	public Date getPanaInData() {
		return panaInData;
	}

	public void setPanaInData(Date panaInData) {
		this.panaInData = panaInData;
	}
}
