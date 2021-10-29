package tn.esprit.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.demo.entities.DetailProduit;
import tn.esprit.demo.entities.Produit;
import tn.esprit.demo.repository.DetailProduitRepository;
import tn.esprit.demo.repository.ProduitRepository;

import java.util.List;

public class ProduitServiceImpl implements ProduitService{

    @Autowired
    private ProduitRepository produitRepository;
    private DetailProduitRepository detailProduitRepository;

    @Override
    public Produit get(Long id) {
        return produitRepository.getById(id);
    }

    @Override
    public void saveProduit(Produit p, Long idRayon, Long idStock) {
        produitRepository.save(p);
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }
}
