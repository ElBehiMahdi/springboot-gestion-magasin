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

import javax.persistence.*;

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

	@ManyToOne
	@JoinColumn(name = "clients_id_client")
	private Client clients;

	public Long getIdDetailProduit() {
		return idDetailProduit;
	}

	public void setIdDetailProduit(Long idDetailProduit) {
		this.idDetailProduit = idDetailProduit;
	}

	public float getMontantRemise() {
		return montantRemise;
	}

	public void setMontantRemise(float montantRemise) {
		this.montantRemise = montantRemise;
	}

	public float getMontantFacture() {
		return montantFacture;
	}

	public void setMontantFacture(float montantFacture) {
		this.montantFacture = montantFacture;
	}

	public Date getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<detailFacture> getDf() {
		return df;
	}

	public void setDf(Set<detailFacture> df) {
		this.df = df;
	}

	public Client getClients() {
		return clients;
	}

	public void setClients(Client clients) {
		this.clients = clients;
	}
}
