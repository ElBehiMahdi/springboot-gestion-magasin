package tn.esprit.demo.service;

import java.util.List;
import java.util.Date;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.entities.CategorieClient;

public interface ClientService {
List<Client> retrieveAllClients();
	Client addClient(Client c);
	void deleteClientById(Long clientId);
	Client updateClient(Client c);
	Client retrieveClientById(Long clientId);
	float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate);
}
