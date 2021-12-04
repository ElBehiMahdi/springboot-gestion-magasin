package tn.esprit.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Client implements Serializable{

	@Id
	//@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	private long idClient;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private CategorieClient categorieclient;
	@Enumerated(EnumType.STRING)
	private Profession profession;
	private String phone;
	private String imageUrl;
	@Column(nullable= false, updatable= false)
	private String clientCode;
	
	public Client(long idClient, String nom, String prenom, Date dateNaissance, String email, String password,
			CategorieClient categorieclient, Profession profession, String phone, String imageUrl, String clientCode) 
	{
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.password = password;
		this.categorieclient = categorieclient;
		this.profession = profession;
		this.phone= phone;
		this.imageUrl= imageUrl;
		this.clientCode= clientCode;
	}

	public Client() {

	}

	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
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
	public String getPhone(){
		return phone;
	}
	public void setPhone(String phone){
		this.phone= phone;
	}
	public String getImageUrl(){
		return imageUrl;
	}
	public void setImageUrl(String imageUrl){
		this.imageUrl= imageUrl;
	}
	public String getClientCode(){
		return clientCode;
	}
	public void setClientCode(String clientCode){
		this.clientCode= clientCode;
	}
	public String toString()
	{
		return "Client{"+ 
				"id= "+ idClient + 
				", nom= "+ nom +
				", prenom="+ prenom +
				", date de naissance= " + dateNaissance + 
				", email= "+ email +
				", password= "+ password + 
				", categorieclient= "+ categorieclient +
				", profession= "+ profession + 
				", phone= "+ phone +
				", imageUrl= "+ imageUrl +
				", clientCode= "+ clientCode + 
				"}";
	}
	@OneToMany(mappedBy="clients")
	private List<Facture> factures;
	
}

