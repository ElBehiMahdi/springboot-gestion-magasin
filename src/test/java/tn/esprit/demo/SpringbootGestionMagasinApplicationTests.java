package tn.esprit.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.entities.Fournisseur;
import tn.esprit.demo.entities.Produit;
import tn.esprit.demo.service.ClientService;
import tn.esprit.demo.service.FournisseurService;
import tn.esprit.demo.service.ProduitService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootGestionMagasinApplicationTests {

    @Autowired
    ProduitService pr;
    @Autowired
    FournisseurService fr;
    @Transactional
    @org.junit.Test
    public void TestAssignStock(){
        boolean b = false ;
        pr.assignProduitToStock(1L,2L);
        Produit p = pr.retrieveProduit(1L);
        if (p.getStock().getIdStock() == 2L ){
            b= true;
        }
        assertTrue(b);
    }

    /*
    @Transactional
    @Test
    public void TestAssignFournisseur(){
        boolean b = false ;
        pr.assignFournisseurToProduit(2L,1L);
        Produit p = pr.retrieveProduit(1L);
        Fournisseur f = fr.retrieveFournisseur(2L);
        log.warn(f.getLibelle());
        if (p.getFournisseur().contains(f)  ){
            b= true;
        }
        assertTrue(b);
    }

	/*
	@Autowired
	ClientService clientService ;

	@Test
	public void testDeleteClient()
	{
		Client c= new Client() ;
		clientService.saveClient(c);
		List<Client> cs = clientService.getAllClients();
		int expected = cs.size();
		clientService.deleteClient(c.getIdClient());
		assertEquals(expected-1,clientService.getAllClients().size());
	}

	private void assertEquals(int i, int size) {
	}
	 */
}
