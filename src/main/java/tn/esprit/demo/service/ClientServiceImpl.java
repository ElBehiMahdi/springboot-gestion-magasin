package tn.esprit.demo.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.entities.CategorieClient;
import tn.esprit.demo.entities.Facture;
import tn.esprit.demo.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientRepository clientRepository;
	
	public List<Client> retrieveAllClients() {
		List<Client> clients= (List<Client>) clientRepository.findAll();
		for(Client client: clients){
			log.info(" client : "+ client);
		}
		return clients;
	}

	@Override
	public Client addClient(Client c) {
		log.info("In method addClient");
		return clientRepository.save(c);
	}

	@Override
	public void deleteClientById(Long clientId) {
		log.info("in delete client by id");
		log.warn("Attention, you sure you wanna delete?!");
		clientRepository.deleteById(clientId);
		log.error("Exception");
	}

	@Override
	public Client updateClient(Client c) {
		return clientRepository.save(c) ;
	}

	@Override
	public Client retrieveClientById(Long clientId) {
		log.info("in method retrieve client by id");
		Client client= clientRepository.findById(clientId).get() ;
		return client;
		//return clientRepository.findById(clientId).get() ;
	}

	@Override
	public float getChiffreAffaireParCategorieClient(CategorieClient categorieclient, Date startDate, Date endDate) {
		float chiffre_affaire=0;
		List<Facture> factures= clientRepository.getClientsByCategorie(categorieclient);
		for(Facture facture: factures){
		if(facture.getDateFacture().compareTo(startDate)>0 && facture.getDateFacture().compareTo(endDate)<0){
			chiffre_affaire+=facture.getMontantFacture();
		}
		}
		return chiffre_affaire;
	}
}
