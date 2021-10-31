package tn.esprit.demo.service;

import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Fournisseur;

import java.util.List;
public interface FournisseurService {
    List<Fournisseur> retrieveAllFournisseur ();

    Fournisseur addFournisseur(Fournisseur f);

    void deleteFournisseur(Long id);

    Fournisseur updateFournisseur(Fournisseur f);

    Fournisseur retrieveFournisseur(Long id);
}
