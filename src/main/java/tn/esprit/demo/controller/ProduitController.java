package tn.esprit.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.entities.Produit;
import tn.esprit.demo.service.ClientService;
import tn.esprit.demo.service.ProduitService;

import java.util.List;
@RestController
@RequestMapping("/api")
public class ProduitController {

    ProduitService produitService;
    @Autowired
    public ProduitController(ProduitService service){
        this.produitService=service;
    }

    @GetMapping(value = "/produits")
    public List<Produit> getAllProduits(){
        return produitService.getAllProduits();
    }

    @GetMapping(value="/getProduit/{id}")
    public Produit getProduitById(@PathVariable("id") Long id) {
        Produit produit = produitService.get(id);
        return produit;
    }
    @PostMapping(value="/addProduit")
    public void addProduit(@RequestBody Produit produit) {
        produitService.saveProduit(produit);
    }
    @PutMapping(value="/updateProduit/{id}")
    public void updateProduit(@PathVariable("id") Long id, @RequestBody Produit produit) {
        Produit p = produitService.get(id);
        p.setDetailProduit(p.getDetailProduit());
        produitService.saveProduit(produit);
    }
}
