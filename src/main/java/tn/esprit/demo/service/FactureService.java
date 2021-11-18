package tn.esprit.demo.service;

import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.entities.Facture;

import java.util.Date;
import java.util.List;
public interface FactureService {
    public abstract Facture getFactureById(Long id);
    public abstract void cancelFacture(Long id);
    public abstract List<Facture> getAllFactures();
    float calculChiffreAffaires(Date d1, Date d2);

}
