package tn.esprit.demo.service;

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
	
	
	@Override
	public Client retrieveClientById(Long idClient)
	{
		return clientRepository.findById(idClient).orElseThrow(() -> 
		new ClientNotFoundException("Client by id"+ idClient+" was not found")) ;
	}

	
	@Override
	public float getChiffreAffaireParCategorieClient(CategorieClient categorieclient, Date startDate, Date endDate) 
	{
		float chiffre_affaire=0;
		List<Facture> factures= clientRepository.getClientsByCategorie(categorieclient);
		for(Facture facture: factures){
		if(facture.getDateFacture().compareTo(startDate)>0 && facture.getDateFacture().compareTo(endDate)<0){
			chiffre_affaire+=facture.getMontantFacture();
		}
		}
		return chiffre_affaire;
	}

	
	@Override
	public float getFactureRecenteParIdClient(Long idClient, Date dateRecente)
	{
		float facture_recente=0;
		List<Facture> factures= clientRepository.getClientById(idClient);
		for(Facture facture: factures){
			if(facture.getDateFacture().compareTo(dateRecente)>0){
				facture_recente+= facture.getMontantFacture();
			}
		}
		return facture_recente;
	}

	public Client updateClientById(Long id, Client client)
	{
		Client c  = clientRepository.findById(id).orElseThrow(() ->
		new ClientNotFoundException("Cliend does not exist with id: " + id));
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
	
	public float clientProfessionPourcentage(Profession prof)
	{
		int allClients=retrieveAllClients().size();
		int clientsByProf=FindAllClientsByProfession(prof).size();
		float pourcentage=((float)clientsByProf/allClients)*100;
		return pourcentage;
	}

	public List<Client> FindAllClientsByProfession(Profession prof) 
	{
		return clientRepository.findByProfession(prof);
	}

	
	
	
}
