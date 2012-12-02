package ro.ubbcluj.cs.Biblioteca.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	private int idUser;
	private String username;
	private String password;
	private String nume;
	private String email;
	private String telefon;
	private String adresa;
	private int drepturi;
	private List<Imprumut> cartiImprumutate;
	private List<Rezervare> rezervari;
	
	public User() { }
	
	public User(int idUser, String username, String password, String nume,
			String email, String telefon, String adresa, int drepturi) {
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.nume = nume;
		this.email = email;
		this.telefon = telefon;
		this.adresa = adresa;
		this.drepturi = drepturi;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public int getDrepturi() {
		return drepturi;
	}
	public void setDrepturi(int drepturi) {
		this.drepturi = drepturi;
	}

	public List<Imprumut> getCartiImprumutate() {
		return cartiImprumutate;
	}

	public void setCartiImprumutate(List<Imprumut> cartiImprumutate) {
		this.cartiImprumutate = cartiImprumutate;
	}

	public List<Rezervare> getRezervari() {
		return rezervari;
	}

	public void setRezervari(List<Rezervare> rezervari) {
		this.rezervari = rezervari;
	}
}
