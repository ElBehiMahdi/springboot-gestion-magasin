package tn.esprit.demo.service;

import tn.esprit.demo.entities.Client;

import java.util.List;
public interface ClientService {
    public abstract Client getClientById(Long id);
    public abstract void saveClient(Client c);
    public abstract void updateClient(Client c);
    public abstract void deleteClient(Long id);
    public abstract List<Client> getAllClients();
}
