package tn.esprit.demo.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Rayon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="idRayon")
	private Long idRayon ;
	private String code;
	private String libelle ;
	@OneToMany(mappedBy="")
	private Set<Produit> P;
	
	public Rayon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rayon(Long idRayon, String code, String libelle) {
		super();
		this.idRayon = idRayon;
		this.code = code;
		this.libelle = libelle;
	}
	public Long getIdRayon() {
		return idRayon;
	}
	public void setIdRayon(Long idRayon) {
		this.idRayon = idRayon;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	

}
