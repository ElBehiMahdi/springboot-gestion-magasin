package tn.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.demo.entities.Facture;

public interface FactureRepository extends JpaRepository<Facture,Long> {
}
