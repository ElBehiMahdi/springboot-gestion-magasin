package tn.esprit.demo.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Data
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
	private Produit produit;

	// Many to one association detailFacture *-1 Facture
	@ManyToOne
	Facture facture;
}
