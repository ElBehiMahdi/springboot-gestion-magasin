package tn.esprit.demo.service;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Facture;
import tn.esprit.demo.repository.ClientRepository;
import tn.esprit.demo.repository.FactureRepository;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.service.ClientServiceImp;

import javax.transaction.Transactional;
import java.util.List;
@Service
public abstract class FactureServiceImpl implements FactureService{
	@Autowired
	FactureRepository f;
	ClientService cs;
    @Autowired
    private FactureRepository factureRepository;

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
		Client c=this.cs.getClientById(idClient);
		f.setClient(c);
		float somme=0;
		for(int i=0;i<f.getDetailfacture().size();i++) {
			somme+=f.getDetailfacture().get(i).getPrixTotal();
		}
		f.setMontantFacture(somme);
		somme=0;
		for( int i=0;i<f.getDetailfacture().size();i++) {
			somme+=f.getDetailfacture().get(i).getMontantRemise();
		}
		f.setMontantRemise(somme);
		this.f.save(f);
		return f;
	}
	
}