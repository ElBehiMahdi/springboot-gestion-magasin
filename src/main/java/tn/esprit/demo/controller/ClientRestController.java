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
	
	class ClientRestController{
		@Autowired
		ClientService clientService;
		
		@GetMapping("/getMsg")
		public String greeting(){
			return "spring security example";
		}
		
		@GetMapping("/all")
		public ResponseEntity<List<Client>> FetchAllClients()
		{
			List <Client> clients = clientService.retrieveAllClients();
			return new ResponseEntity<>(clients, HttpStatus.OK);
		}

		@GetMapping("/fetch/{idClient}")
		public ResponseEntity<Client> FetchClientById(@PathVariable("idClient") Long idClient)
		{
			Client client = clientService.retrieveClientById(idClient);
			return new ResponseEntity<>(client, HttpStatus.OK);
		}

		@PostMapping("/add")
		public Client addClient(@RequestBody Client newClient)
		{
			return clientService.addClient(newClient);
		}

		@PutMapping("/update")
		public ResponseEntity<Client> updateClient(@RequestBody Client client)
		{
			Client updateClient = clientService.updateClient(client);
			return new ResponseEntity<>(updateClient, HttpStatus.OK);
		}
		
		@PutMapping("/update/{idClient}")
		public Client updateClientById(@PathVariable("idClient") Long idClient, @RequestBody Client client)
		{
			return clientService.updateClientById(idClient, client);
		}

		@DeleteMapping("/delete/{idClient}")
		public ResponseEntity<?> deleteClient(@PathVariable("idClient") Long idClient)
		{
			clientService.deleteClient(idClient);
			return new ResponseEntity<>(HttpStatus.OK);
		}

		//TODO fix this
		@PostMapping("/getChiffreAffaire/{client-categorie}/{startDate}/{endDate}")//cuz we are not viewing sth that can't be changed like in Get
		@ApiOperation(value="getChiffreAffaireParCategorieClient")
		@ResponseBody
		public float getChiffreAffaireParCategorieClient(@PathVariable("client-categorie") String categorieclient,
														 @PathVariable
														 @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)Date startDate,
														 @PathVariable
														 @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)Date endDate)
		{
			return clientService.getChiffreAffaireParCategorieClient(CategorieClient.valueOf(categorieclient), startDate, endDate);
		}

		//TODO fix this
		@PostMapping("/getFactureRecenteParIdClient/{idClient}/{dateRecente}")
		@ApiOperation(value="getFactureRecenteParIdClient")
		@ResponseBody
		public float getFactureRecenteParIdClient(@PathVariable Long idClient,
												  @PathVariable
												  @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)Date dateRecente)
		{
			return clientService.getFactureRecenteParIdClient(idClient, dateRecente);
		}
		
		@GetMapping("/clientProfessionPourcentage/{prof}")
		public float clientProfessionPourcentage(@PathVariable Profession prof)
		{
			return clientService.clientProfessionPourcentage(prof);
		}
	
		
		
		
		
	
	
}