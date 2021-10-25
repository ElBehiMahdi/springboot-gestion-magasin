package tn.esprit.demo.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
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
	@OneToOne
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

	// Constructor et accesseurs (getters) et mutateurs (setters) }

	public Produit(Long idProduit, String code, String libelle, float prixUnitaire) {
		super();
		this.idProduit = idProduit;
		this.code = code;
		this.libelle = libelle;
		this.prixUnitaire = prixUnitaire;
	}

	public Produit() {


	}

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
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

	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

}
