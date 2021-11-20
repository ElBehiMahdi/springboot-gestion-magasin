package tn.esprit.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.demo.entities.Facture;
import tn.esprit.demo.entities.Produit;
import tn.esprit.demo.entities.detailFacture;
import tn.esprit.demo.repository.DetailFactureRepository;
import tn.esprit.spring.entity.DetailFacture;

 

@Service
public interface DetailFactureServiceImp {
	@Autowired
	DetailFactureRepository df;
	
	@Override
	public detailFacture addDetailFacture(detailFacture df,Produit p,Facture f) {
		df.setProduit(p);
		df.setFacture(f);
		df.setPrixTotal(p.getPrixUnitaire()*df.getQte());
		df.setMontantRemise((int)(df.getPourcentageRemise()*df.getPrixTotal()/100));
		this.dfr.save(df);
		return df; 
	}
}
