package tn.esprit.demo.service;

import tn.esprit.demo.entities.DetailProduit;
import tn.esprit.demo.entities.Produit;

import java.util.List;

public interface ProduitService {
    List<Produit> retrieveAllProduits();

    Produit addProduit(Produit p, Long idRayon, Long idStock);

    Produit retrieveProduit(Long id);

    void assignProduitToStock(Long idProduit, Long idStock);

    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) ;
}
