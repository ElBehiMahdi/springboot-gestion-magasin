package tn.esprit.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.entities.Produit;
import tn.esprit.demo.entities.Rayon;
import tn.esprit.demo.entities.Stock;
import tn.esprit.demo.service.ClientService;
import tn.esprit.demo.service.ProduitService;
import tn.esprit.demo.service.RayonService;
import tn.esprit.demo.service.StockService;

import java.util.List;
@RestController
@Api(tags = "Produit management")
@RequestMapping("/produit")
public class ProduitRestController {

    @Autowired
    ProduitService produitService;
    @Autowired
    RayonService rayonService;
    @Autowired
    StockService stockService;

    // http://localhost:8089/SpringMVC/produit/retrieve-all-produits
    @GetMapping("/retrieve-all-produits")
    @ApiOperation(value = "Récupérer la liste des produits")
    @ResponseBody
    public List<Produit> getProduits() {
        List<Produit> listProduits = produitService.getAllProduits();
        return listProduits;
    }

    // http://localhost:8089/SpringMVC/produit/retrieve-produit/8
    @GetMapping("/retrieve-produit/{produit-id}")
    @ApiOperation(value = "Récupérer un produit par id")
    @ResponseBody
    public Produit retrieveProduit(@PathVariable("produit-id") Long produitId) {
        return produitService.get(produitId);
    }

    // http://localhost:8089/SpringMVC/produit/add-produit
    @PostMapping("/add-produit")
    @ApiOperation(value = "Ajouter un produit")
    @ResponseBody
    public Produit addProduit(@RequestBody Produit p,Long idRayon, Long idStock)
    {
        Produit produit = produitService.saveProduit(p,idRayon,idStock);
        //Stock stock = stockService.get(idStock);
        //Rayon rayon = rayonService.getRayon(idRayon);
        //produit.setStock(stock);
        //produit.setRayon(rayon);
        return produit;
        //TODO entité detail produit associé avec produit ajouté
        // TODO assign rayon and stock
        //  https://stackoverflow.com/questions/60590410/spring-crudrepository-how-do-i-insert-a-record-by-foreign-key-id

    }

    /*
    // http://localhost:8089/SpringMVC/produit/remove-produit/{produit-id}
    @DeleteMapping("/remove-produit/{produit-id}")
    @ResponseBody
    public void removeProduit(@PathVariable("produit-id") Long produitId) {
        produitService.deleteProduit(produitId);
    }
    */

    /*
    // http://localhost:8089/SpringMVC/produit/modify-produit
    @PutMapping("/modify-produit")
    @ResponseBody
    public Produit modifyProduit(@RequestBody Produit produit) {
        return produitService.updateProduit(produit);
    }
     */

}
