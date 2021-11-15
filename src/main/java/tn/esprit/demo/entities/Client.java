package tn.esprit.demo.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;


@Entity
@Getter
@ToString
@RequiredArgsConstructor
public class Client implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4039704037349167269L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private Long idClient;
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
	
	// One to many association Client 1-* Facture
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	@ToString.Exclude
	private Set<Facture> f;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Client client = (Client) o;
		return idClient != null && Objects.equals(idClient, client.idClient);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCategorieclient(CategorieClient categorieclient) {
		this.categorieclient = categorieclient;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public void setF(Set<Facture> f) {
		this.f = f;
	}

	public Long getIdClient() {
		return idClient;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public CategorieClient getCategorieclient() {
		return categorieclient;
	}

	public Profession getProfession() {
		return profession;
	}

	public Set<Facture> getF() {
		return f;
	}
}