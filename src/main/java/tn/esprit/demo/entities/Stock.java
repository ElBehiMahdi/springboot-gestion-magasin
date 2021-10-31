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
	private Set<Produit> P;
}
