package tn.esprit.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.*;
import tn.esprit.demo.repository.*;

import java.util.Date;
import java.util.List;
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
    public Produit addProduit(Produit p, Long idRayon, Long idStock) {
        Rayon r = rayonRepo.getById(idRayon);
        Stock s = stockRepo.getById(idStock);
        p.setRayon(r);
        p.setStock(s);
        // produit.setFournisseur AJOUT STATIQUE EN TEST
        DetailProduit dp = p.getDetailProduit();
        detailProduitRepo.save(dp);
        return produitRepo.save(p);

    }


    //TODO
    // Le chef rayon désire changer le stock d’un produit
    //  Créer un service permettant l’assignation d’un produit à un stock et exposer le en
    //      respectant la signature suivante :
    @Override
    public  void assignProduitToStock(Long idProduit, Long idStock) {
        Produit p = new Produit();
        p = produitRepo.getById(idProduit);
        Stock s = new Stock();
        s = stockRepo.getById(idStock);
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

    //TODO
    // Nous souhaitons calculer le revenu brut généré par un produit entre deux dates.
    //  Créer un service permettant de faire le calcul en respectant la signature suivante :
    //  PS : le revenu brut généré correspond aux montants générées par la vente de ce
    //      produit ( prix * quantité pour les différentes factures)
    void getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate){}

    @Override
    public Produit retrieveProduit(Long id) {
        return produitRepo.getById(id);
    }
}
