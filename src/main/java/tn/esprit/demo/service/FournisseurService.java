package tn.esprit.demo.service;

import tn.esprit.demo.entities.Client;
import tn.esprit.demo.entities.Fournisseur;

import java.util.List;

public interface FournisseurService {
    public abstract Fournisseur getFournisseurById(Long id);
    public abstract void saveFournisseur(Fournisseur f);
    public abstract void updateFournisseur(Fournisseur f);
    public abstract void deleteFournisseur(Long id);
    public abstract List<Fournisseur> getAllFournisseur();
}
