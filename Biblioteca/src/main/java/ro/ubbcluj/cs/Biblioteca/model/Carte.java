package ro.ubbcluj.cs.Biblioteca.model;

import java.io.Serializable;

public class Carte implements Serializable{
	private int idCarte;
	private String cota;
	private String titlu;
	private String autori;
	private String isbn;
	private String editura;
	private String locAparitie;
	private int anAparitie;
	private String observatii;
	private int durataImprumut;
	
	public Carte(int idCarte, String cota, String titlu, String autori,
			String isbn, String editura, String locAparitie, int anAparitie,
			String observatii, int durataImprumut) {
		this.idCarte = idCarte;
		this.cota = cota;
		this.titlu = titlu;
		this.autori = autori;
		this.isbn = isbn;
		this.editura = editura;
		this.locAparitie = locAparitie;
		this.anAparitie = anAparitie;
		this.observatii = observatii;
		this.durataImprumut = durataImprumut;
	}

	public Carte() { }

	public int getIdCarte() {
		return idCarte;
	}

	public void setIdCarte(int idCarte) {
		this.idCarte = idCarte;
	}

	public String getCota() {
		return cota;
	}

	public void setCota(String cota) {
		this.cota = cota;
	}

	public String getTitlu() {
		return titlu;
	}

	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}

	public String getAutori() {
		return autori;
	}

	public void setAutori(String autori) {
		this.autori = autori;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEditura() {
		return editura;
	}

	public void setEditura(String editura) {
		this.editura = editura;
	}

	public String getLocAparitie() {
		return locAparitie;
	}

	public void setLocAparitie(String locAparitie) {
		this.locAparitie = locAparitie;
	}

	public int getAnAparitie() {
		return anAparitie;
	}

	public void setAnAparitie(int anAparitie) {
		this.anAparitie = anAparitie;
	}

	public String getObservatii() {
		return observatii;
	}

	public void setObservatii(String observatii) {
		this.observatii = observatii;
	}

	public int getDurataImprumut() {
		return durataImprumut;
	}

	public void setDurataImprumut(int durataImprumut) {
		this.durataImprumut = durataImprumut;
	}
}
