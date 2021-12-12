package tn.esprit.demo.service;

import tn.esprit.demo.entities.CategorieProduit;
import tn.esprit.demo.entities.Produit;
import tn.esprit.demo.entities.Rayon;

import java.util.List;
import java.util.Optional;

public interface ProduitService {
    List<Produit> retrieveAllProduits();

    List<Produit> getProduitByCategorieProduit(CategorieProduit cat);

    Produit addProduit(Produit p, Long idRayon, Long idStock);

    Optional<Produit> retrieveProduit(Long id);

    void assignProduitToStock(Long idProduit, Long idStock);

    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) ;

    void removeProduitById(Long idProduit);

    Produit updateProduit(Produit p);

}
