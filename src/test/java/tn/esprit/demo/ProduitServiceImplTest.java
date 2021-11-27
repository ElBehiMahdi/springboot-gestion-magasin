package tn.esprit.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.demo.entities.Fournisseur;
import tn.esprit.demo.entities.Produit;
import tn.esprit.demo.repository.FournisseurRepository;
import tn.esprit.demo.repository.ProduitRepository;
import tn.esprit.demo.service.FournisseurService;
import tn.esprit.demo.service.ProduitService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProduitServiceImplTest {
    @Autowired
    ProduitService pr;

    @Autowired
    FournisseurService fr;

    @Transactional
    @Test
    public void TestAssignStock(){
        boolean b = false ;
        pr.assignProduitToStock(1L,2L);
        Optional<Produit> p = pr.retrieveProduit(1L);
        if (p.get().getStock().getIdStock() == 2L ){
            b= true;
        }
        assertTrue(b);
    }

    @Transactional
    @Test
    public void TestAssignFournisseur(){
        boolean b = false ;
        pr.assignFournisseurToProduit(2L,1L);
        Optional<Produit> p = pr.retrieveProduit(1L);
        Fournisseur f = fr.retrieveFournisseur(2L);
        if (p.get().getFournisseur().contains(f)  ){
            b= true;
        }
        assertTrue(b);
    }
}

