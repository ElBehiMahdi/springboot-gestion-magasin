package tn.esprit.demo.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.repository.ClientRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    @JsonIgnore
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

    @Override
    public List<Client> retrieveClientsDate(Date date1, Date date2) {
        return clientRepository.retrieveClientsDate(date1,date2);
    }
}
