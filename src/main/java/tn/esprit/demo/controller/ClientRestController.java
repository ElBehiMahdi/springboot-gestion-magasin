package tn.esprit.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.service.ClientService;

import java.util.List;
@RestController
@RequestMapping("/client")
public class ClientRestController {

    @Autowired
    ClientService clientService;

    // http://localhost:8089/SpringMVC/client/retrieve-all-clients
    @GetMapping("/retrieve-all-clients")
    @ResponseBody
    public List<Client> getClients() {
        List<Client> listClients = clientService.getAllClients();
        return listClients;
    }

    // http://localhost:8089/SpringMVC/client/retrieve-client/8
    @GetMapping("/retrieve-client/{client-id}")
    @ResponseBody
    public Client retrieveClient(@PathVariable("client-id") Long clientId) {
        return clientService.getClientById(clientId);
    }
    // http://localhost:8089/SpringMVC/client/add-client
    @PostMapping("/add-client")
    @ResponseBody
    public Client addClient(@RequestBody Client c)
    {
        Client client = clientService.saveClient(c);
        return client;
    }

    // http://localhost:8089/SpringMVC/client/remove-client/{client-id}
    @DeleteMapping("/remove-client/{client-id}")
    @ResponseBody
    public void removeClient(@PathVariable("client-id") Long clientId) {
        clientService.deleteClient(clientId);
    }
    // http://localhost:8089/SpringMVC/client/modify-client
    @PutMapping("/modify-client")
    @ResponseBody
    public Client modifyClient(@RequestBody Client client) {
        return clientService.updateClient(client);
    }

}
