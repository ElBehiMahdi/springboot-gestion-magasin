package tn.esprit.demo.service;

import tn.esprit.demo.entities.Client;
import tn.esprit.demo.entities.Facture;

import java.util.List;

public interface FactureService {
    public abstract Facture getFactureById(Long id);
    public abstract void cancelFacture(Long id);
    public abstract List<Facture> getAllFactures();
}
