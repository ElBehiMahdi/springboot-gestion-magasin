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
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;

@Entity

@Getter
@Setter
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)	

@Table(name="facture")
public class Facture implements Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idDetailProduit;
	 float montantRemise;
	 float montantFacture;
	 @Temporal(TemporalType.DATE)
	 Date dateFacture;
	 Boolean active;

	// Many to one association Facture *-1 Client
	@ManyToOne
	Client client;

	// One to many association Facture 1-* detailFacture
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facture")
	private Set<detailFacture> df;

	public List<Facture> getDetailfacture() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setMontantFacture(float somme) {
		// TODO Auto-generated method stub
		
	}

	public float getMontantRemise() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float getPrixTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setMontantRemise(float somme) {
		// TODO Auto-generated method stub
		
	}

	 
	 
	 
	

	 
	 
}
