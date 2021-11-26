package tn.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.demo.entities.detailProduit;

@Repository
public interface DetailProduitRepository extends JpaRepository<detailProduit, Long> {
}
