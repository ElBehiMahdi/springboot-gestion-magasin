package tn.esprit.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "Produit")
public class Produit implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProduit")
	private Long idProduit; // Clé primaire
	private String code;
	private String libelle;
	private float prixUnitaire;
	@Enumerated(EnumType.STRING)
	private CategorieProduit categorieProduit;

	// One to one association Produit 1-1 detailProduit
	@OneToOne
	private detailProduit detailProduit;

	// Many to One association Produit *-1 Rayon
	@JsonIgnore
	@ManyToOne
	Rayon rayon;

	// Many to One association Produit *-1 Stock
	@JsonIgnore
	@ManyToOne
	Stock stock;

	// One to many association Produit 1-* detailfacture
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
	@ToString.Exclude
	private Set<detailFacture> detailFactures;


	// Many to many association Produit *-* Fournisseur
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@ToString.Exclude
	private Set<Fournisseur> fournisseur;
	public float getPrixUnitaire;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Produit produit = (Produit) o;
		return idProduit != null && Objects.equals(idProduit, produit.idProduit);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
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

	public detailProduit getDetailProduit() {
		return detailProduit;
	}

	public void setDetailProduit(detailProduit detailProduit) {
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

	public CategorieProduit getCategorieProduit() {
		return categorieProduit;
	}

	public void setCategorieProduit(CategorieProduit categorieProduit) {
		this.categorieProduit = categorieProduit;
	}
}
