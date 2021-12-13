package tn.esprit.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.transaction.Transactional;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tn.esprit.demo.entities.CategorieClient;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.entities.Facture;
import tn.esprit.demo.entities.Profession;
import tn.esprit.demo.exception.ClientNotFoundException;
import tn.esprit.demo.repository.ClientRepository;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientRepository clientRepository;
	
	/*@Autowired
	FactureRepository FactureRepository;*/

	@Override
	public List<Client> retrieveAllClients() 
	{
		return (List<Client>) clientRepository.findAll();
	}

	@Override
	public Client addClient(Client newClient) 
	{
		return clientRepository.save(newClient);
	}
	
	public void deleteClient(Long idClient) 
	{
		clientRepository.deleteById(idClient);
	}
	
	
	@Override
	public Client updateClient(Client client)
	{
		return clientRepository.save(client) ;
	}
	

	public Client updateClientById(Long id, Client client)
	{
		Client c  = clientRepository.findById(id).orElseThrow(() ->
		new ClientNotFoundException("Client does not exist with id: " + id));
		c.setNom(client.getNom());
		c.setPrenom(client.getPrenom());
		c.setDateNaissance(client.getDateNaissance());
		c.setEmail(client.getEmail());
		c.setCategorieclient(client.getCategorieclient());
		c.setProfession(client.getProfession());
		c.setPhone(client.getPhone());
		c.setCin(client.getCin());
		
		Client updatedClient= clientRepository.save(c);
		return updatedClient;
	}
	
	
	@Override
	public Client retrieveClientById(Long idClient)
	{
		return clientRepository.findById(idClient).orElseThrow(() -> 
		new ClientNotFoundException("Client by id"+ idClient+" was not found")) ;
	}

	

	public float chiffreAffaireDeFactures(List<Facture> listFacture) 
	{
		float chiffreAffaire= 0.0f;
		for(int i=0 ; i < listFacture.size() ; i++)
		{
			chiffreAffaire= chiffreAffaire + (listFacture.get(i).getMontantFacture()-listFacture.get(i).getMontantRemise());
		}
		return chiffreAffaire;
	}

	
	@Override
	public float getChiffreAffaireParCategorieClient(CategorieClient categorieclient, Date startDate, Date endDate) 
	{
		float chiffreAffaire = 0.0f;
		List<Client> clientList = FindAllClientsByCategorie(categorieclient);
		for(int k=0 ; k< clientList.size() ; k++)
		{
			chiffreAffaire= chiffreAffaire + chiffreAffaireDeFactures(clientFacturesBetweenTwoDates(clientList.get(k), startDate, endDate));
		}	
		return 0;
	}

	
	public float clientProfessionPourcentage(Profession prof)
	{
		int allClients= retrieveAllClients().size();
		int clientsByProf= FindAllClientsByProfession(prof).size();
		float pourcentage= ((float)clientsByProf/allClients)*100;
		return pourcentage;
	}

	public List<Client> FindAllClientsByProfession(Profession prof) 
	{
		return clientRepository.findByProfession(prof);
	}

	@Override
	public List<Client> addClients(List<Client> Clients) 
	{
		return clientRepository.saveAll(Clients);
	}

	@Override
	public List<Client> FindAllClientsByCategorie(CategorieClient categorieclient) 
	{
		return clientRepository.findByCategorieclient(categorieclient);
	}

	@Override
	public List<Facture> clientFacturesBetweenTwoDates(Client c, Date startDate, Date endDate) 
	{
		List<Facture> listFacture= c.getFactures();
		List<Facture> listFactureBetweenDates = new ArrayList<>();
		for(int i=0;i<listFacture.size();i++)
		{
			if (listFacture.get(i).getDateFacture().getTime() >= startDate.getTime() && listFacture.get(i).getDateFacture().getTime() <= endDate.getTime() ) 
			{
				listFactureBetweenDates.add(listFacture.get(i));	
			}
		}
			
		return listFactureBetweenDates;
	}

	
}
