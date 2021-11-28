package tn.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.demo.entities.detailFacture;

@Repository
public interface DetailFactureRepository extends JpaRepository<detailFacture,Long>{
}
