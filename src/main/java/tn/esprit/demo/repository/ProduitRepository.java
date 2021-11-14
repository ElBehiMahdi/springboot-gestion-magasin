package tn.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.demo.entities.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {
    //void saveProduit(Produit p, Long idRayon, Long idStock);
}
