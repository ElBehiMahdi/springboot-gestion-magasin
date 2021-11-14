package tn.esprit.demo.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Fournisseur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idFournisseur")
	private Long idFournisseur;
	private String code;
	private String libelle;

	// Many to many association Fournisseur *-* Produit
	@ManyToMany(cascade = CascadeType.ALL)
	@ToString.Exclude
	private Set<Produit> produits;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Fournisseur that = (Fournisseur) o;
		return idFournisseur != null && Objects.equals(idFournisseur, that.idFournisseur);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
