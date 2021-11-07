package tn.esprit.demo.service;

import tn.esprit.demo.entities.DetailProduit;
import tn.esprit.demo.entities.Produit;

import java.util.List;

public interface ProduitService {
    public abstract Produit get(Long id);
    public abstract Produit saveProduit(Produit p);
    public abstract List<Produit> getAllProduits();
}
