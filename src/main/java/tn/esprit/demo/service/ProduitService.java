package tn.esprit.demo.service;

import tn.esprit.demo.entities.Produit;

import java.util.List;
import java.util.Optional;

public interface ProduitService {
    List<Produit> retrieveAllProduits();

    Produit addProduit(Produit p, Long idRayon, Long idStock);

    Optional<Produit> retrieveProduit(Long id);

    void assignProduitToStock(Long idProduit, Long idStock);

    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) ;
}
