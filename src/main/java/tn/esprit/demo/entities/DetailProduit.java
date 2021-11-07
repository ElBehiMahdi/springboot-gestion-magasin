package tn.esprit.demo.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Data
@Table(name = "DetailProduit")
public class DetailProduit implements Serializable {
	/**
		 * 
		 */
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
	private Produit produit;
}
