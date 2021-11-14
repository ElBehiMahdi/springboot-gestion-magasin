package tn.esprit.demo.service;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Facture;
import tn.esprit.demo.repository.ClientRepository;
import tn.esprit.demo.repository.FactureRepository;

import javax.transaction.Transactional;
import java.util.List;
@Service
public abstract class FactureServiceImpl implements FactureService{

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
	public Facture addFacture(Facture f) {
		return factureRepository.save(f);
	}
   
    public  Facture getFactureByClientFacture(long clientId) {
    	return factureRepository.getById(clientId);
    
    }
}