package tn.esprit.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.Fournisseur;
import tn.esprit.demo.entities.Rayon;
import tn.esprit.demo.entities.Stock;
import tn.esprit.demo.service.FournisseurService;

import java.util.List;
import java.util.Optional;

@RestController
@Api(tags = "Fournisseurs management")
@RequestMapping("/fournisseur")
public class FournisseurRestController {
    @Autowired
    FournisseurService fournisseurService;

    @GetMapping("/retrieve-all-fournisseur")
    @ApiOperation(value = "Récupérer la liste des fournisseurs")
    @ResponseBody
    public List<Fournisseur> getFournisseur() {
        List<Fournisseur> listFournisseur = fournisseurService.retrieveAllFournisseur();
        return listFournisseur;
    }

    // http://localhost:8089/SpringMVC/stock/retrieve-stock/1
    @GetMapping("/retrieve-stock/{stock-id}")
    @ApiOperation(value = "Récupérer un stock par id")
    @ResponseBody
    public Optional<Stock> retrieveStock(@PathVariable("stock-id") Long stockId) {
        return stockService.get(stockId);
    }
}
