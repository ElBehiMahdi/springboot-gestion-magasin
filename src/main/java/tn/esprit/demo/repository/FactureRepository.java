package tn.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.demo.entities.Facture;

import java.util.Date;

@Repository
public interface FactureRepository extends JpaRepository<Facture,Long> {
    @Query("SELECT  SUM (f.montantFacture) FROM Facture f WHERE f.dateFacture BETWEEN :date1 and :date2")
    float calculChiffreAffaires(@Param("date1") Date date1, @Param("date2") Date date2);
}
