package tn.esprit.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.repository.ClientRepository;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client getClientById(Long id) {
        return clientRepository.getById(id);
    }

    @Override
    public Client saveClient(Client c) {
        clientRepository.save(c);
        return c;
    }

    @Override
    public Client updateClient(Client c) {
        clientRepository.save(c);
        return c;
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
