package tn.esprit.demo.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.entities.CategorieClient;
import tn.esprit.demo.entities.Facture;
import tn.esprit.demo.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientRepository clientRepository;

	@Override
	public List<Client> retrieveAllClients() {

		return clientRepository.findAll();
	}

	@Override
	public Client addClient(Client c) {
		return clientRepository.save(c);
	}

	@Override
	public void deleteClientById(Long clientId) {

		clientRepository.deleteById(clientId);
	}

	@Override
	public Client updateClient(Client c) {

		return clientRepository.save(c) ;
	}

	@Override
	public Client retrieveClientById(Long clientId) {

		return clientRepository.findById(clientId).get() ;
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
