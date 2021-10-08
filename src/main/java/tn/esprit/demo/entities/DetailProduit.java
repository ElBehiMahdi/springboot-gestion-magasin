package tn.esprit.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column; import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "DetailProduit")
public class DetailProduit implements Serializable {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name="idDetailProduit")
private Long idDetailProduit; // Clé primaire
@Temporal(TemporalType.DATE)
private Date dateCreation; 
private String dateDerniereModification; 
@Enumerated(EnumType.STRING)
private CategorieProduit categorieProduit;

public DetailProduit(Long idDetailProduit, Date dateCreation, String dateDerniereModification,
		CategorieProduit categorieProduit) {
	super();
	this.idDetailProduit = idDetailProduit;
	this.dateCreation = dateCreation;
	this.dateDerniereModification = dateDerniereModification;
	this.categorieProduit = categorieProduit;
}
public Long getIdDetailProduit() {
	return idDetailProduit;
}
public void setIdDetailProduit(Long idDetailProduit) {
	this.idDetailProduit = idDetailProduit;
}
public Date getDateCreation() {
	return dateCreation;
}
public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}
public String getDateDerniereModification() {
	return dateDerniereModification;
}
public void setDateDerniereModification(String dateDerniereModification) {
	this.dateDerniereModification = dateDerniereModification;
}
public CategorieProduit getCategorieProduit() {
	return categorieProduit;
}
public void setCategorieProduit(CategorieProduit categorieProduit) {
	this.categorieProduit = categorieProduit;
}


//Constructor et accesseurs (getters) et mutateurs (setters) }
}
