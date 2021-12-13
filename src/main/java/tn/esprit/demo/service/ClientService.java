package tn.esprit.demo.service;

import java.util.List;
import java.util.Date;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.entities.Profession;
import tn.esprit.demo.entities.CategorieClient;

public interface ClientService {
	List<Client> retrieveAllClients();
	Client addClient(Client newClient);
	void deleteClient(Long idClient);
	Client updateClient(Client c);
	List<Client> FindAllClientsByProfession(Profession prof);
	Client retrieveClientById(Long idClient);
	Client updateClientById(Long idClient, Client c); 
	float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate);
	float getFactureRecenteParIdClient(Long clientId, Date dateRecente);
	float clientProfessionPourcentage(Profession profession);
}
