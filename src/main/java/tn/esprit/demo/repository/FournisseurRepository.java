package tn.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.demo.entities.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
}
