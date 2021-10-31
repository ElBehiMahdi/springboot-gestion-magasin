package tn.esprit.demo.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Produit")
public class Produit implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProduit")
	private Long idProduit; // Clé primaire
	private String code;
	private String libelle;
	private float prixUnitaire;

	// One to one association Produit 1-1 detailProduit
	@OneToOne(fetch = FetchType.LAZY,
			cascade =  CascadeType.ALL,
			mappedBy = "produit")
	private DetailProduit detailProduit;

	// Many to One association Produit *-1 Rayon
	@ManyToOne
	Rayon rayon;

	// Many to One association Produit *-1 Stock
	@ManyToOne
	Stock stock;

	// One to many association Produit 1-* detailfacture
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
	private Set<detailFacture> detailFactures;


	// Many to many association Produit *-* Fournisseur
	@ManyToMany(mappedBy = "produits", cascade = CascadeType.ALL)
	private Set<Fournisseur> fournisseur;
}
