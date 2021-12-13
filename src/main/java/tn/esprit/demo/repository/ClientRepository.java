package tn.esprit.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.entities.CategorieClient;
import tn.esprit.demo.entities.Facture;
import tn.esprit.demo.entities.Profession;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository	
public interface ClientRepository extends JpaRepository<Client,Long> {

	@Query("select c.factures from Client c where c.categorieclient=: categorieclient")
		//cuz we need les factures du client not the client himself
	List<Facture> getClientsByCategorie(@Param("categorieclient") CategorieClient categorieclient);

	@Query("select c.factures from Client c where c.id=: id")
	List<Facture> getClientById(@Param("idClient") Long idClient);

	Client findByUserName(String username);

	List<Client> findByProfession(Profession prof);
}
	
	
	
