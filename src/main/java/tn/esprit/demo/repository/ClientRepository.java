package tn.esprit.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.entities.CategorieClient;
import tn.esprit.demo.entities.Facture;
import tn.esprit.demo.entities.Profession;


import org.springframework.stereotype.Repository;


@Repository	
public interface ClientRepository extends JpaRepository<Client,Long> {

	Client findByUserName(String username);


	List<Client> findByProfession(Profession prof);


	List<Client> findByCategorieClient(CategorieClient categorieClient);


}
	
	
	
