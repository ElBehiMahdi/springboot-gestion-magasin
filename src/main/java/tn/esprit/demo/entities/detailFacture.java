package tn.esprit.demo.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity
@Table(name="detailfacture")

@Getter
@Setter
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class detailFacture implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 Long idDetailFacture;
	@NotNull
	Integer qte;
	@NotNull
	 Float prixTotal;
	@NotNull
	Integer pourcentageRemise;
	@NotNull
	 Float montantRemise;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idProduit", nullable = false)
	private Produit produit;

	// Many to one association detailFacture *-1 Facture
	@ManyToOne
	Facture facture;

	public float getQte() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getProduit() {
		// TODO Auto-generated method stub
		return null;
	}

	public float getPourcentageRemise() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setMontantRemise(float montantRemiseDetail) {
		// TODO Auto-generated method stub
		
	}

	public void setPrixTotal(float prixTotalDetailRemise) {
		// TODO Auto-generated method stub
		
	}

	public void setProduit(Produit produit2) {
		// TODO Auto-generated method stub
		
	}

	public void setFacture(Facture f) {
		// TODO Auto-generated method stub
		
	}
}
