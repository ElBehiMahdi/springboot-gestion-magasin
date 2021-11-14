package tn.esprit.demo.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class detailFacture implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDetailFacture;
	private Integer qte;
	private Float prixTotal;
	private Integer pourcentageRemise;
	private Float montantRemise;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idProduit", nullable = false)
	@ToString.Exclude
	private Produit produit;

	// Many to one association detailFacture *-1 Facture
	@ManyToOne
	Facture facture;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		detailFacture that = (detailFacture) o;
		return idDetailFacture != null && Objects.equals(idDetailFacture, that.idDetailFacture);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
