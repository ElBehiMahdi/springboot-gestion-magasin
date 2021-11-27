package tn.esprit.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.entities.Facture;
import tn.esprit.demo.entities.Produit;
import tn.esprit.demo.entities.detailFacture;
import tn.esprit.demo.repository.ClientRepository;
import tn.esprit.demo.repository.DetailFactureRepository;
import tn.esprit.demo.repository.FactureRepository;
import tn.esprit.demo.repository.ProduitRepository;

@Service
public class FactureServiceImpl implements FactureService{
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
			float prixTotalDetail=detail.getQte()*produit.getPrixUnitaire;
			float montantRemiseDetail=(prixTotalDetail * detail.getPourcentageRemise())/100;
			float prixTotalDetailRemise= prixTotalDetail - montantRemiseDetail ;
			detail.setMontantRemise(montantRemiseDetail);
			detail.setPrixTotal(prixTotalDetailRemise);
			montantFacture= montantFacture + prixTotalDetailRemise;
			montantRemise= montantRemise + montantRemiseDetail;
			detail.setProduit(produit);
			detail.setFacture(f);
			dfr.save(detail);
		}
		f.setMontantFacture(montantFacture);
		f.setMontantRemise(montantRemise);
		return f;
		
	}
	
}