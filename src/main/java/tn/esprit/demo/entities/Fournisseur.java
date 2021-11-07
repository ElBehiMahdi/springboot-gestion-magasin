package tn.esprit.demo.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@Data
public class Fournisseur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idFournisseur")
	private Long idFournisseur;
	private String code;
	private String libelle;

	// Many to many association Fournisseur *-* Produit
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Produit> produits;
}
