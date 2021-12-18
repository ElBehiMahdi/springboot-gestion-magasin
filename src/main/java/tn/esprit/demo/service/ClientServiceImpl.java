package tn.esprit.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	tn.esprit.demo.repository.FactureRepository FactureRepository;

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


	public float TotalFactEntreDates(Client c, Date startDate, Date endDate) {
		float TotalFact= 0.0f;
		List<Facture> listFacture= c.getFactures();
		List<Facture> LfactEntreDates = new ArrayList<>();
		for(int j=0;j<listFacture.size();j++)
		{
			if (listFacture.get(j).getDateFacture().compareTo(startDate)>=0 &&
					listFacture.get(j).getDateFacture().compareTo(endDate)<=0)
			{
				LfactEntreDates.add(listFacture.get(j));
			}
			TotalFact+= listFacture.get(j).getMontantFacture()-listFacture.get(j).getMontantRemise();
		}
		return TotalFact;
	}




	@Override
	public float getChiffreAffaireParCategorieClient(CategorieClient categorieclient, Date startDate, Date endDate)
	{
		float chiffre_affaire=0.0f;
		List<Client> clients= clientRepository.findBycategorieclient(categorieclient);
		for(int k=0;k<clients.size();k++)
		{
			chiffre_affaire+= TotalFactEntreDates(clients.get(k), startDate, endDate);
		}
		return chiffre_affaire;
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
