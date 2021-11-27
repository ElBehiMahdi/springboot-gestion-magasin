package tn.esprit.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Facture;
import tn.esprit.demo.entities.Produit;
import tn.esprit.demo.entities.detailFacture;
import tn.esprit.demo.repository.ClientRepository;
import tn.esprit.demo.repository.DetailFactureRepository;
import tn.esprit.demo.repository.FactureRepository;
import tn.esprit.demo.repository.ProduitRepository;

@Service
public abstract class FactureServiceImpl implements FactureService{
	@Autowired
	FactureRepository f;
	@Autowired
	ClientRepository cr;
	@Autowired
	ProduitRepository pr;
    @Autowired
    private FactureRepository factureRepository;
	@Autowired
	private DetailFactureRepository dfr;

    @Override
    public Facture getFactureById(Long id) {
        return factureRepository.getById(id);
    }

    @Override
    public void cancelFacture(Long id) {
        if (factureRepository.getById(id).getActive() == true){
            factureRepository.getById(id).setActive(false);
        }
    }

    @Override
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }
    @Override
	public List<Facture> getByIdClient(Long idClient) {
		return (List<Facture>)this.f.getFacturesByClient(idClient);
	
	}
	
	@Override
	public Facture addFacture(Facture f, Long idClient) {
<<<<<<< HEAD
		Client client = ClientRepository.findById(idClient).orElse(null);
		f.setClient(client);
		f.setDateFacture(new Date());
		f.setActive(true);
		Set<detailFacture> detailsFacture = f.getDetailfacture();
		Facture fact =addDetailsFacture(f,detailsFacture);
		return factureRepository.save(fact);
	}
	private Facture addDetailsFacture(Facture f, Set<detailFacture> detailsFacture){
		float montantFacture=0;
		float montantRemise =0;
		for(detailFacture detail: detailsFacture ){
			Produit produit = ProduitRepository.findById(detail.getProduit().getIdProduit()).orElse(null);
=======
		Client client = cr.getById(idClient);
		f.setClient(client);
		f.setDateFacture(new Date());
		f.setActive(true);
		List<detailFacture> detailsFacture = dfr.findAll();
		Facture fact =addDetailsFacture(f,detailsFacture);
		return factureRepository.save(fact);
	}
	private Facture addDetailsFacture(Facture f, List<detailFacture> detailsFacture){
		float montantFacture=0;
		float montantRemise =0;
		for(detailFacture detail: detailsFacture ){
			Produit produit = pr.getById(detail.getProduit().getIdProduit());
>>>>>>> 8c592d4f92a3ef91cc95b68585c0cf3f31a8b7cc
			float prixTotalDetail=detail.getQte()*produit.getPrixUnitaire;
			float montantRemiseDetail=(prixTotalDetail * detail.getPourcentageRemise())/100;
			float prixTotalDetailRemise= prixTotalDetail - montantRemiseDetail ;
			detail.setMontantRemise(montantRemiseDetail);
			detail.setPrixTotal(prixTotalDetailRemise);
			montantFacture= montantFacture + prixTotalDetailRemise;
			montantRemise= montantRemise + montantRemiseDetail;
			detail.setProduit(produit);
			detail.setFacture(f);
<<<<<<< HEAD
			DetailFactureRepository.save(detail);		
=======
			dfr.save(detail);
>>>>>>> 8c592d4f92a3ef91cc95b68585c0cf3f31a8b7cc
		}
		f.setMontantFacture(montantFacture);
		f.setMontantRemise(montantRemise);
		return f;
		
	}
	
}