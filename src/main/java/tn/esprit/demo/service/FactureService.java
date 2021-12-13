package tn.esprit.demo.service;

import tn.esprit.demo.entities.Facture;

import java.util.List;

public interface FactureService {
     Facture getFactureById(Long id);
     void cancelFacture(Long id);
     List<Facture> getAllFactures();
     List<Facture> getByIdClient(Long id);//Long idClient
     Facture addFactureClient(Long idFacture, Long idClient);
     Facture addFacture(Facture f);
     Facture updateFacture(Facture f);
}
