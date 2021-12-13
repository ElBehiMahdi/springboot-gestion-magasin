package tn.esprit.demo.service;

import java.util.ArrayList;
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

import javax.transaction.Transactional;

@Service
public class FactureServiceImpl implements FactureService{

	@Autowired
	FactureRepository FactureRepository;

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	ProduitRepository produitRepository;

	@Autowired
	DetailFactureRepository detailFactureRepository;

	@Override
	public List<Facture> getAllFactures() {

		return  (List<Facture>) FactureRepository.findAll();
	}

	@Override

	public void cancelFacture(Long id) {

		Facture f = FactureRepository.findById(id).get();
		f.setActive(false);
		FactureRepository.save(f);

	}

	@Override
	public Facture getFactureById(Long id) {

		return FactureRepository.findById(id).get();
	}

	@Override
	public Facture addFacture(Facture f) {

		return FactureRepository.save(f);
	}

	@Override
	public Facture updateFacture (Facture f) {
		return FactureRepository.save(f);
	}


	@Override
	public List<Facture> getByIdClient(Long idClient) {
		if(clientRepository.findById(idClient).isPresent())
		{
			Client c = clientRepository.findById(idClient).get();
			List<Facture> factures = new ArrayList<>();
			factures.addAll(c.getFactures());
			return factures;
		}
		return null;
	}

	public Facture addDetailsFacture(Facture f,List<detailFacture> detailsFacture){
		float montantRemise=0;
		float montantFacture=0;
		for(detailFacture detail:detailsFacture){
			Produit produit=produitRepository.getById(detail.getProduit().getIdProduit());
			float prixTotalDetail=detail.getQte()*produit.getPrixUnitaire();
			float montantRemiseDetail=(prixTotalDetail*detail.getPourcentageRemise())/100;
			float prixTotalDetailRemise=prixTotalDetail-montantRemiseDetail;
			detail.setMontantRemise(montantRemiseDetail);
			detail.setPrixTotal(prixTotalDetailRemise);
			montantFacture+=prixTotalDetailRemise;
			montantRemise+=montantRemiseDetail;
			detail.setProduit(produit);
			detail.setFacture(f);
			detail.setCreatedAt(new Date());
			detailFactureRepository.save(detail);
		}
		f.setMontantFacture(montantFacture);
		f.setMontantRemise(montantRemise);
		return f;
	}

	//TODO fix facture null
	@Transactional
	public Facture addFactureClient(Long idFacture, Long idClient) {
		Facture f=FactureRepository.getById(idFacture);
		f.setClient(clientRepository.getById(idClient));
		f.setDateFacture(new Date());
		f.setActive(true);
		List<detailFacture> detailsFacture=(List<detailFacture>) f.getDetailFacture();
		Facture facture=addDetailsFacture(f,detailsFacture);
		return FactureRepository.save(facture);
	}
}