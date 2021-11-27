package tn.esprit.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
public class Fournisseur implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idFournisseur")
	private Long idFournisseur;
	private String code;
	private String libelle;

	// Many to many association Fournisseur *-* Produit
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Produit> produits;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Fournisseur that = (Fournisseur) o;
		return idFournisseur != null && Objects.equals(idFournisseur, that.idFournisseur);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	public Long getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(Long idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}
}
