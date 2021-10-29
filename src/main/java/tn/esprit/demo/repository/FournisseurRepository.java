package tn.esprit.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.demo.entities.Fournisseur;

@Repository
public interface FournisseurRepository extends CrudRepository<Fournisseur, Long> {
}
