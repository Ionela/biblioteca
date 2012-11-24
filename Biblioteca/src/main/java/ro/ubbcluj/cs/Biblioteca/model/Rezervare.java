package ro.ubbcluj.cs.Biblioteca.model;

import java.util.Date;

public class Rezervare {

	private int idRezervare;
	private Carte carte;
	private User user;
	private Date dinData;
	private Date panaInData;
	
	public Rezervare(int idRezervare, Carte carte, User user, Date dinData,
			Date panaInData) {
		this.idRezervare = idRezervare;
		this.carte = carte;
		this.user = user;
		this.dinData = dinData;
		this.panaInData = panaInData;
	}
	
	public int getIdRezervare() {
		return idRezervare;
	}
	public void setIdRezervare(int idRezervare) {
		this.idRezervare = idRezervare;
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
