package tn.esprit.demo.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Data
public class Rayon implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idRayon")
	private Long idRayon;
	private String code;
	private String libelle;
	
	// One to many association Rayon 1-* Produit
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rayon")
	private Set<Produit> P;
}
