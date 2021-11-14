package tn.esprit.demo.entities;

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
	@ToString.Exclude
	private Set<detailFacture> detailFactures;


	// Many to many association Produit *-* Fournisseur
	@ManyToMany(cascade = CascadeType.ALL)
	@ToString.Exclude
	private Set<Fournisseur> fournisseur;

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
}
