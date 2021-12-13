package tn.esprit.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.entities.Facture;
import tn.esprit.demo.service.ClientService;
import tn.esprit.demo.service.FactureService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(tags = "Facture management")
@RequestMapping("/facture")
public class FactureRestController {

    @Autowired
    FactureService factureService;

    //http://localhost:8089/SpringMVC/facture/retrieve-all-factures
    @GetMapping("/retrieve-all-factures")
    @ApiOperation(value = "Récupérer la liste des factures")
    @ResponseBody
    public List<Facture> getFacture() {

        List<Facture> listFacture = factureService.getAllFactures();
        return listFacture;
    }

    //http://localhost:8089/SpringMVC/facture/retrieve-facture/1
    @GetMapping("/retrieve-facture/{facture-id}")
    @ApiOperation(value = "Récupérer une facture par id")
    @ResponseBody
    public Facture retrieveFacture(@PathVariable("facture-id") Long factureId) {

        return factureService.getFactureById(factureId);
    }

    //http://localhost:8089/SpringMVC/facture/cancel-facture/1
    @PutMapping("/cancel-facture/{facture-id}")
    @ApiOperation(value = "Annuler une facture")
    @ResponseBody
    public void cancelFacture(@PathVariable("facture-id") Long factureId) {

        factureService.cancelFacture(factureId);
    }

    //http://localhost:8089/SpringMVC/facture/getFactureByClient/1
    @GetMapping("/getFactureByClient/{clientId}")
    @ResponseBody
    public List<Facture> getFactureByClient(@PathVariable("clientId") long ClientId) {

        return factureService.getByIdClient(ClientId);
    }

    //TODO fix
    //http://localhost:8081/SpringMVC/facture/add-facture/1
    @PostMapping("/add-facture/{idf}/{clientId}")
    public Facture addFacture(@PathVariable("idf") Long idf,@PathVariable("clientId") long ClientId) {
        Facture facture = factureService.addFactureClient(idf,ClientId);
        return facture;
    }

    @PutMapping("/modify-Facture")
    @ResponseBody
    public Facture modifyFacture(@RequestBody Facture facture) {
        return factureService.updateFacture(facture);
    }


    //http://localhost:8081/SpringMVC/facture/add-facture
    @PostMapping("/add-facture")
    @ResponseBody
    public Facture addFacture(@RequestBody Facture f) {
        Facture facture = factureService.addFacture(f);
        return facture;
    }
}

