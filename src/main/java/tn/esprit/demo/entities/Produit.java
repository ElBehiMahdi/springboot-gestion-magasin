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

	public Produit(String code, String libelle, float prixUnitaire) {
		this.code = code;
		this.libelle = libelle;
		this.prixUnitaire = prixUnitaire;
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

	public DetailProduit getDetailProduit() {
		return detailProduit;
	}

	public void setDetailProduit(DetailProduit detailProduit) {
		this.detailProduit = detailProduit;
	}

	public Rayon getRayon() {
		return rayon;
	}

	public void setRayon(Rayon rayon) {
		this.rayon = rayon;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Set<detailFacture> getDetailFactures() {
		return detailFactures;
	}

	public void setDetailFactures(Set<detailFacture> detailFactures) {
		this.detailFactures = detailFactures;
	}

	public Set<Fournisseur> getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Set<Fournisseur> fournisseur) {
		this.fournisseur = fournisseur;
	}
}
