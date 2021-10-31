package tn.esprit.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Fournisseur;
import tn.esprit.demo.repository.FournisseurRepository;

import java.util.List;

@Service
public class FournisseurServiceImpl implements FournisseurService{
    @Autowired
    private FournisseurRepository fournisseurRepository;


    @Override
    public List<Fournisseur> retrieveAllFournisseur() {
        return fournisseurRepository.findAll();
    }

    @Override
    public Fournisseur addFournisseur(Fournisseur f) {
        return fournisseurRepository.save(f);
    }

    @Override
    public void deleteFournisseur(Long id) {
        fournisseurRepository.deleteById(id);
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur f) {
        return fournisseurRepository.save(f);
    }

    @Override
    public Fournisseur retrieveFournisseur(Long id) {
        return fournisseurRepository.getById(id);
    }
}
