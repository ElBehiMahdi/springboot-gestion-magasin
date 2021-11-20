package tn.esprit.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.service.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@Api(tags = "Client management")
@RequestMapping("/client")
public class ClientRestController {

    @Autowired
    ClientService clientService;

    // http://localhost:8089/SpringMVC/client/retrieve-all-clients
    @GetMapping("/retrieve-all-clients")
    @ApiOperation(value = "Récupérer la liste des clients")
    @ResponseBody
    public List<Client> getClients() {
        List<Client> listClients = clientService.getAllClients();
        return listClients;
    }

    // http://localhost:8089/SpringMVC/client/retrieve-client/8
    @GetMapping("/retrieve-client/{client-id}")
    @ApiOperation(value = "Récupérer un client par id")
    @ResponseBody
    public Optional<Client> retrieveClient(@PathVariable("client-id") Long clientId) {
        return clientService.getClientById(clientId);
    }
    // http://localhost:8089/SpringMVC/client/add-client
    @PostMapping("/add-client")
    @ApiOperation(value = "Ajouter un client")
    @ResponseBody
    public Client addClient(@RequestBody Client c)
    {
        Client client = clientService.saveClient(c);
        return client;
    }

    // http://localhost:8089/SpringMVC/client/remove-client/{client-id}
    @DeleteMapping("/remove-client/{client-id}")
    @ApiOperation(value = "Supprimer un client")
    @ResponseBody
    public void removeClient(@PathVariable("client-id") Long clientId) {
        clientService.deleteClient(clientId);
    }
    // http://localhost:8089/SpringMVC/client/modify-client
    @PutMapping("/modify-client")
    @ApiOperation(value = "Modifier un client")
    @ResponseBody
    public Client modifyClient(@RequestBody Client client) {
        return clientService.updateClient(client);
    }

}
