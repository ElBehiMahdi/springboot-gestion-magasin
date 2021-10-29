package tn.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.demo.entities.DetailProduit;

public interface DetailProduitRepository extends JpaRepository<DetailProduit, Long> {
}
