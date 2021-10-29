package tn.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.demo.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
