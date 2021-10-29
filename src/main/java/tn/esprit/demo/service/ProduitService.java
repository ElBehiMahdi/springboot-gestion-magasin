package tn.esprit.demo.service;

import tn.esprit.demo.entities.DetailProduit;
import tn.esprit.demo.entities.Produit;

import java.util.List;

public interface ProduitService {
    public abstract Produit get(Long id);
    public abstract void saveProduit(Produit p, Long idRayon, Long idStock);
    public abstract List<Produit> getAllProduits();
}
