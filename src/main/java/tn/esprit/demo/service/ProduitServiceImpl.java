package tn.esprit.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.demo.entities.*;
import tn.esprit.demo.repository.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProduitServiceImpl implements ProduitService{

    @Autowired
    ProduitRepository produitRepo;
    @Autowired
    RayonRepository rayonRepo;
    @Autowired
    StockRepository stockRepo;
    @Autowired
    DetailProduitRepository detailProduitRepo;
    @Autowired
    FournisseurRepository fournisseurRepo;

    @Override
    public List<Produit> retrieveAllProduits() {
        return produitRepo.findAll();
    }

    @Override
    public List<Produit> getProduitByCategorieProduit(CategorieProduit cat) {
        return  produitRepo.getProduitByCategorieProduit(cat);
    }

    @Override
    public Produit addProduit(Produit p, Long idRayon, Long idStock) {
        Rayon r = rayonRepo.getById(idRayon);
        Stock s = stockRepo.getById(idStock);
        s.setQte(s.getQte()+1);
        p.setRayon(r);
        p.setStock(s);
        //TODO figure out detail produit bug
        return produitRepo.save(p);
    }

    @Override
    public  void assignProduitToStock(Long idProduit, Long idStock) {
        Produit p = new Produit();
        p = produitRepo.getById(idProduit);
        Stock s = new Stock();
        s = stockRepo.getById(idStock);
        s.setQte(s.getQte()+1);
        p.setStock(s);
        produitRepo.saveAndFlush(p);
    }

    @Override
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
        Fournisseur f = fournisseurRepo.getById(fournisseurId);
        Produit p = produitRepo.getById(produitId);
        p.getFournisseur().add(f);
        produitRepo.saveAndFlush(p);
    }

    @GetMapping(value = "/getRevenuBrutProduit/{idProduit}/{startDate}/{endDate}")
    float getRevenuBrutProduit(@PathVariable("idProduit") Long idProduit,
                               @PathVariable(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                               @PathVariable(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate){

        return produitRepo.getRevenuBrutProduit(idProduit,startDate,endDate);
    }

    @Override
    public Optional<Produit> retrieveProduit(Long id) {

        return produitRepo.findById(id);
    }

    @Override
    public void removeProduitById(Long idProduit) {

        produitRepo.deleteById(idProduit);
    }

    @Override
    public Produit updateProduit(Produit p) {
        return produitRepo.save(p);
    }
}
