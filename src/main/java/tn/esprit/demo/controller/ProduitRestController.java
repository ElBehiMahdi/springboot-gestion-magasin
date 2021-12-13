package tn.esprit.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.*;
import tn.esprit.demo.service.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
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
    @Autowired
    FournisseurService fr;

    //http://localhost:8089/SpringMVC/produit/retrieve-all-produits
    @GetMapping("/retrieve-all-produits")
    @ResponseBody
    @ApiOperation(value ="Récupérer la liste des produits")
    public List<Produit> getProduits() {
        List<Produit> listProduits = produitService.retrieveAllProduits();
        return listProduits;
    }

    //http://localhost:8089/SpringMVC/produit/retrieve-all-produits
    @GetMapping("/retrieve-all-produits-byCat/{categorie}")
    @ResponseBody
    @ApiOperation(value ="Récupérer la liste des produits par categorie")
    public List<Produit> getProduitsByCat(@PathVariable("categorie") CategorieProduit categorie) {
        List<Produit> listProduits = produitService.getProduitByCategorieProduit(categorie);
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
    public void addProduit(@RequestBody Produit p,@PathVariable("rayon-id") Long idRayon,@PathVariable("stock-id") Long idStock) {

        Produit product = produitService.addProduit(p,idRayon,idStock);
    }

    //http://localhost:8089/SpringMVC/produit/modify-produit
    @PutMapping("/modify-produit")
    @ApiOperation(value = "Modifier un Produit")
    @ResponseBody
    public Produit modifyProduit(@RequestBody Produit p) {
        return produitService.updateProduit(p);
    }

    //http://localhost:8089/SpringMVC/produit/remove-produit/1
    @DeleteMapping("remove-produit/{idProduit}")
    @ApiOperation(value="Remove produit by id")
    @ResponseBody
    public void removeProduitById(@PathVariable("idProduit") Long idProduit) {
        produitService.removeProduitById(idProduit);
    }

}
