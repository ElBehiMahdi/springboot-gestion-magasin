package tn.esprit.demo.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Data
public class Facture implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFacture;
	private float montantRemise;
	private float montantFacture;
	private Date dateFacture;
	private Boolean active;

	// Many to one association Facture *-1 Client
	@ManyToOne
	Client client;

	// One to many association Facture 1-* detailFacture
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facture")
	private Set<detailFacture> df;

	public boolean getActive() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setActive(boolean b) {
		// TODO Auto-generated method stub
		
	}

	 
	

	public void setPrenom(String string) {
		// TODO Auto-generated method stub
		
	}
}
