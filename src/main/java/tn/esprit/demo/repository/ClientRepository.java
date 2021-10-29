package tn.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.demo.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
