package tn.esprit.demo.service;

import tn.esprit.demo.entities.Facture;
import tn.esprit.demo.entities.Produit;
import tn.esprit.demo.entities.detailFacture;

public interface DetailFactureService {
	detailFacture addDetailFacture(detailFacture df,Produit p,Facture f);
}
