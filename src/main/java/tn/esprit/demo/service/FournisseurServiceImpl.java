package tn.esprit.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.demo.entities.Fournisseur;
import tn.esprit.demo.repository.ClientRepository;
import tn.esprit.demo.repository.FournisseurRepository;

import java.util.List;

public class FournisseurServiceImpl implements FournisseurService{

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Override
    public Fournisseur getFournisseurById(Long id) {
        return fournisseurRepository.getById(id);
    }

    @Override
    public void saveFournisseur(Fournisseur f) {
        fournisseurRepository.save(f);
    }

    @Override
    public void updateFournisseur(Fournisseur f) {
        fournisseurRepository.save(f);
    }

    @Override
    public void deleteFournisseur(Long id) {
        fournisseurRepository.deleteById(id);
    }

    @Override
    public List<Fournisseur> getAllFournisseur() {
        return fournisseurRepository.findAll();
    }
}
