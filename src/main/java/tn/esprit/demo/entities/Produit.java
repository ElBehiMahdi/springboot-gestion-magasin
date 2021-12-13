package tn.esprit.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Produit")
public class Produit implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProduit")
	private long idProduit; // Clé primaire
	private String code;
	private String libelle;
	private float prixUnitaire;
	@Enumerated(EnumType.STRING)
	private CategorieProduit categorieProduit;

	// One to one association Produit 1-1 detailProduit
	@JsonIgnore
	@OneToOne
	private detailProduit detailProduit;

	// Many to One association Produit *-1 Rayon
	@ManyToOne
	private Rayon rayon;

	// Many to One association Produit *-1 Stock
	@ManyToOne
	private Stock stock;

	// One to many association Produit 1-* detailfacture
	@JsonIgnore
	@OneToMany(mappedBy = "produit")
	private Set<detailFacture> detailFacture;


	// Many to many association Produit *-* Fournisseur
	@JsonIgnore
	@ManyToMany()
	private Set<Fournisseur> fournisseur;


	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	public long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(long idProduit) {
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

	public CategorieProduit getCategorieProduit() {
		return categorieProduit;
	}

	public void setCategorieProduit(CategorieProduit categorieProduit) {
		this.categorieProduit = categorieProduit;
	}

	public tn.esprit.demo.entities.detailProduit getDetailProduit() {
		return detailProduit;
	}

	public void setDetailProduit(tn.esprit.demo.entities.detailProduit detailProduit) {
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

	public Set<tn.esprit.demo.entities.detailFacture> getDetailFacture() {
		return detailFacture;
	}

	public void setDetailFacture(Set<tn.esprit.demo.entities.detailFacture> detailFacture) {
		this.detailFacture = detailFacture;
	}

	public Set<Fournisseur> getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Set<Fournisseur> fournisseur) {
		this.fournisseur = fournisseur;
	}
}
