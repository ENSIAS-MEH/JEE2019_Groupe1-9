package metier;

import java.io.Serializable;

public class User implements Serializable{
	public String id;
	public String nom;
	public String prenom;
	private String cin;
	public String mail;
	public String sexe;
	public String nationalite;
	private String mdp;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String nom, String prenom, String cin, String mail, String sexe, String nationalite,
			String mdp) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.mail = mail;
		this.sexe = sexe;
		this.nationalite = nationalite;
		this.mdp = mdp;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	} 

}
