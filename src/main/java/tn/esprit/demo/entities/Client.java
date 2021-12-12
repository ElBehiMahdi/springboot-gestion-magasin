package tn.esprit.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Client implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "idClient")
	private long idClient;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private String email;
	@Enumerated(EnumType.STRING)
	private CategorieClient categorieclient;
	@Enumerated(EnumType.STRING)
	private Profession profession;
	private int phone;
	private int cin;
	
	private String userName;
	private String password;
	//@ManyToMany(cascade = CascadeType.PERSIST, fetch= FetchType.EAGER)
	//private Set<Role> roles;


	public Client(long idClient, String userName, String password) {
		this.idClient = idClient;
		this.userName = userName;
		this.password = password;
	}

	public Client(long idClient, String nom, String prenom, Date dateNaissance, String email,
				  CategorieClient categorieclient, Profession profession, int phone, int cin, String userName, String password)
	{
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.categorieclient = categorieclient;
		this.profession = profession;
		this.phone= phone;
		this.cin= cin;
		this.userName= userName;
		this.password= password;
		
	}

	public Client() {

	}

	public Client(String userName, String password) {
	}

	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password= password;
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
	}	public int getPhone(){
		return phone;
	}
	public void setPhone(int phone){
		this.phone= phone;
	}
	public int getCin(){
		return cin;
	}
	public void setCin(int cin){
		this.cin= cin;
	}	
	
	public String toString()
	{
		return "Client{"+ 
				"id= "+ idClient + 
				", nom= "+ nom +
				", prenom="+ prenom +
				", date de naissance= " + dateNaissance + 
				", email= "+ email +
				", categorieclient= "+ categorieclient +
				", profession= "+ profession + 
				", phone= "+ phone +
				", cin= "+ cin +
				"}";
	}
	
	@OneToMany(mappedBy="clients")
	private List<Facture> factures;


	public List<Facture> getFactures() {
		return factures;
	}
}

