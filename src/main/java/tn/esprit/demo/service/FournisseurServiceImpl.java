package tn.esprit.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Fournisseur;
import tn.esprit.demo.repository.FournisseurRepository;

import java.util.List;

@Service
public class FournisseurServiceImpl implements FournisseurService{
    @Autowired
    private FournisseurRepository repositoty;


    @Override
    public List<Fournisseur> retrieveAllFournisseur() {
        return null;
    }

    @Override
    public Fournisseur addFournisseur(Fournisseur f) {
        return null;
    }

    @Override
    public void deleteFournisseur(Long id) {

    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur f) {
        return null;
    }

    @Override
    public Fournisseur retrieveFournisseur() {
        return null;
    }

    public FournisseurRepository getRepositoty() {
        return repositoty;
    }

    public void setRepositoty(FournisseurRepository repositoty) {
        this.repositoty = repositoty;
    }
}
