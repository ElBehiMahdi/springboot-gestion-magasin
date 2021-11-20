package tn.esprit.demo.service;

import tn.esprit.demo.entities.Client;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ClientService {
    public abstract Optional<Client> getClientById(Long id);
    public abstract Client saveClient(Client c);
    public abstract Client updateClient(Client c);
    public abstract void deleteClient(Long id);
    public abstract List<Client> getAllClients();
    List<Client> retrieveClientsDate(Date date1, Date date2) ;
}
