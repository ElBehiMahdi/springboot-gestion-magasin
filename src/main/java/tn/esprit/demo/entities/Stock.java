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
	@ToString.Exclude
	private Set<Produit> P;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Stock stock = (Stock) o;
		return idStock != null && Objects.equals(idStock, stock.idStock);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
