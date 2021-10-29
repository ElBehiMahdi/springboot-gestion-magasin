package tn.esprit.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.repository.ClientRepository;

import javax.transaction.Transactional;
import java.util.List;

public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client getClientById(Long id) {
        return clientRepository.getById(id);
    }

    @Override
    public void saveClient(Client c) {
        clientRepository.save(c);
    }

    @Override
    public void updateClient(Client c) {
        clientRepository.save(c);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
