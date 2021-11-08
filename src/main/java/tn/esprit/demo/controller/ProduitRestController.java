package tn.esprit.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.entities.Produit;
import tn.esprit.demo.service.ClientService;
import tn.esprit.demo.service.ProduitService;

import java.util.List;
@RestController
@Api(tags = "Produit management")
@RequestMapping("/produit")
public class ProduitRestController {

    @Autowired
    ProduitService produitService;

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
        return produit;
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
