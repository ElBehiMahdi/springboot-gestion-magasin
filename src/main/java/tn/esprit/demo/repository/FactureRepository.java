package tn.esprit.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.demo.entities.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture,Long> {
	@Query("Select f from Facture f WHERE f.client.idClient like %?1 ")
	List<Facture> getFacturesByClient(Long idClient);//Long idClient
}
