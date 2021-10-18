package tn.esprit.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Client implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4039704037349167269L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private int idClient;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private Date dateNaissance;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	@Enumerated(EnumType.STRING)
	private CategorieClient categorieclient;
	@Column
	@Enumerated(EnumType.STRING)
	private Profession profession;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Facture> f;
	
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
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
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public CategorieClient getCategorieclient() {
		return categorieclient;
	}
	public void setCategorieclient(CategorieClient categorieclient) {
		this.categorieclient = categorieclient;
	}
	public Profession getProfession() {
		return profession;
	}
	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}