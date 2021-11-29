package tn.esprit.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.demo.entities.Facture;
import tn.esprit.demo.entities.Produit;
import tn.esprit.demo.entities.detailFacture;
import tn.esprit.demo.repository.DetailFactureRepository;

@Service
public class DetailFactureServiceImp implements DetailFactureService {

	@Autowired
	DetailFactureRepository dfr;
	
	@Override
	public detailFacture addDetailFacture(detailFacture df, Produit p, Facture f) {
		df.setProduit(p);
		df.setFacture(f);
		df.setPrixTotal(p.getPrixUnitaire()*df.getQte());
		df.setMontantRemise((float) (df.getPourcentageRemise()*df.getPrixTotal()/100));
		this.dfr.save(df);
		return df; 
	}
}
