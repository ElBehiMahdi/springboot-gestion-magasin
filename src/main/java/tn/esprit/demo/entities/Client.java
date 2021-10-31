package tn.esprit.demo.entities;

import lombok.Data;

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
@Data
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
	private Set<Facture> f;
}