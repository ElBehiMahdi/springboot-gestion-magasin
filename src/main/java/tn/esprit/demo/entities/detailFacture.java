package tn.esprit.demo.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class detailFacture implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDetailFacture;
	private Integer qte;
	private Float prixTotal;
	private Integer pourcentageRemise;
	private Float montantRemise;

	// One to many association detailFacture 1-* Produit
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "detailFacture")
	private Set<Produit> P;

	// Many to one association detailFacture *-1 Facture
	@ManyToOne
	Facture facture;

	public detailFacture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public detailFacture(Integer qte, Float prixTotal, Integer pourcentageRemise, Float montantRemise) {
		super();
		this.qte = qte;
		this.prixTotal = prixTotal;
		this.pourcentageRemise = pourcentageRemise;
		this.montantRemise = montantRemise;
	}

	public Long getIdDetailFacture() {
		return idDetailFacture;
	}

	public void setIdDetailFacture(Long idDetailFacture) {
		this.idDetailFacture = idDetailFacture;
	}

	public Integer getQte() {
		return qte;
	}

	public void setQte(Integer qte) {
		this.qte = qte;
	}

	public Float getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(Float prixTotal) {
		this.prixTotal = prixTotal;
	}

	public Integer getPourcentageRemise() {
		return pourcentageRemise;
	}

	public void setPourcentageRemise(Integer pourcentageRemise) {
		this.pourcentageRemise = pourcentageRemise;
	}

	public Float getMontantRemise() {
		return montantRemise;
	}

	public void setMontantRemise(Float montantRemise) {
		this.montantRemise = montantRemise;
	}

	@Override
	public String toString() {
		return "detailFacture [idDetailFacture=" + idDetailFacture + ", qte=" + qte + ", prixTotal=" + prixTotal
				+ ", pourcentageRemise=" + pourcentageRemise + ", montantRemise=" + montantRemise + "]";
	}

}
