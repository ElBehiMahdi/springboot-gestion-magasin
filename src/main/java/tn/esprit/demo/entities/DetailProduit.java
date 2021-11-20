package tn.esprit.demo.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "DetailProduit")
public class DetailProduit implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDetailProduit")
	private Long idDetailProduit; // Clé primaire
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	private Date dateDerniereModification;
	@Enumerated(EnumType.STRING)
	private CategorieProduit categorieProduit;

	// One to One association detailProduit 1-1 Produit
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "produit_id", nullable = false)
	@ToString.Exclude
	private Produit produit;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		DetailProduit that = (DetailProduit) o;
		return idDetailProduit != null && Objects.equals(idDetailProduit, that.idDetailProduit);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	public Long getIdDetailProduit() {
		return idDetailProduit;
	}

	public void setIdDetailProduit(Long idDetailProduit) {
		this.idDetailProduit = idDetailProduit;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateDerniereModification() {
		return dateDerniereModification;
	}

	public void setDateDerniereModification(Date dateDerniereModification) {
		this.dateDerniereModification = dateDerniereModification;
	}

	public CategorieProduit getCategorieProduit() {
		return categorieProduit;
	}

	public void setCategorieProduit(CategorieProduit categorieProduit) {
		this.categorieProduit = categorieProduit;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
}
