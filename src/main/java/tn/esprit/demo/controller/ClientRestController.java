package tn.esprit.demo.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.demo.entities.CategorieClient;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.entities.Profession;
import tn.esprit.demo.service.ClientService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@Api(tags="Client management")
@RequestMapping("/client")

class ClientRestController {
	@Autowired
	ClientService clientService;
		/*
		@GetMapping("/register")
		public String register(){
			return "register";
		}*/

	@GetMapping("/getMsg")
	public String greeting() {
		return "spring security example";
	}

	@GetMapping("/all")
	public ResponseEntity<List<Client>> FetchAllClients() {
		List<Client> clients = clientService.retrieveAllClients();
		return new ResponseEntity<>(clients, HttpStatus.OK);
	}

	@GetMapping("/fetch/{idClient}")
	public ResponseEntity<Client> FetchClientById(@PathVariable("idClient") Long idClient) {
		Client client = clientService.retrieveClientById(idClient);
		return new ResponseEntity<>(client, HttpStatus.OK);
	}

	@PostMapping("/add")
	public Client addClient(@RequestBody Client newClient) {
		return clientService.addClient(newClient);
	}

	@PutMapping("/update")
	public ResponseEntity<Client> updateClient(@RequestBody Client client) {
		Client updateClient = clientService.updateClient(client);
		return new ResponseEntity<>(updateClient, HttpStatus.OK);
	}

	@PutMapping("/update/{idClient}")
	public Client updateClientById(@PathVariable("idClient") Long idClient, @RequestBody Client client) {
		return clientService.updateClientById(idClient, client);
	}

	@DeleteMapping("/delete/{idClient}")
	public ResponseEntity<?> deleteClient(@PathVariable("idClient") Long idClient) {
		clientService.deleteClient(idClient);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/getChiffreAffaire/{categorieclient}/{startDate}/{endDate}")
	@ApiOperation(value = "getChiffreAffaireParCategorieClient")
	@ResponseBody
	public float getChiffreAffaireParCategorieClient(@PathVariable CategorieClient categorieclient,
													 @PathVariable
													 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
													 @PathVariable
													 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
		return clientService.getChiffreAffaireParCategorieClient(categorieclient, startDate, endDate);
	}


	@GetMapping("/clientProfessionPourcentage/{prof}")
	public float clientProfessionPourcentage(@PathVariable Profession prof) {
		return clientService.clientProfessionPourcentage(prof);
	}
}
