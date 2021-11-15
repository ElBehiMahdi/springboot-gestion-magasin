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
public class Stock implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="idStock")
	private Long idStock ;
	private Integer qte;
	private Integer qteMin;
	private String libelle ;
	
	//One to many association Stock 1-* Produit
	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	@ToString.Exclude
	private Set<Produit> P;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Stock stock = (Stock) o;
		return idStock != null && Objects.equals(idStock, stock.idStock);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	public Long getIdStock() {
		return idStock;
	}

	public void setIdStock(Long idStock) {
		this.idStock = idStock;
	}

	public Integer getQte() {
		return qte;
	}

	public void setQte(Integer qte) {
		this.qte = qte;
	}

	public Integer getQteMin() {
		return qteMin;
	}

	public void setQteMin(Integer qteMin) {
		this.qteMin = qteMin;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set<Produit> getP() {
		return P;
	}

	public void setP(Set<Produit> p) {
		P = p;
	}
}
