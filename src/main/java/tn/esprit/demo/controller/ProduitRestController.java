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

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    @ResponseBody
    @ApiOperation(value ="Récupérer la liste des produits")
    public List<Produit> getProduits() {
        List<Produit> listProduits = produitService.retrieveAllProduits();
        return listProduits;
    }

    //http://localhost:8089/SpringMVC/produit/retrieve-produit/3
    @GetMapping("/retrieve-produit/{produit-id}")
    @ResponseBody
    @ApiOperation(value ="Permet de récuperer un produit avec son id")
    public Optional<Produit> retrieveProduit(@PathVariable("produit-id") Long produitId) {
        return produitService.retrieveProduit(produitId);
    }

    //http://localhost:8089/SpringMVC/produit/add-produit
    @PostMapping("/add-produit/{stock-id}/{rayon-id}")
    @ResponseBody
    @ApiOperation(value ="permet d'ajouter un produit")
    public Produit addProduit(@RequestBody Produit p,@PathVariable("rayon-id") Long idRayon,@PathVariable("stock-id") Long idStock) {

        Produit product = produitService.addProduit(p,idRayon,idStock);
        return product;
    }
}
