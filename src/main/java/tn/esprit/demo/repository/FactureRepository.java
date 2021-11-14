package tn.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.demo.entities.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture,Long> {
}
