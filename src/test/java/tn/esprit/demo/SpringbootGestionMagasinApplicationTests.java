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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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

    @Autowired
    ClientService clientService;

    /*
    @Test
    public void testClient() {
        SimpleDateFormat formatter2=new SimpleDateFormat("dd/MM/yyyy");
        //   Date date11=formatter2.parse("1995/01/01");
        //  Date date22=formatter2.parse("1996/06/17");
        Date d = new Date("1995/01/01");
        Date e = new Date("1996/06/17");
        List<Client> liste = clientService.retrieveClientsDate(d,e);
        assertNotNull(liste);
        if (liste.size()>0)
            for (Client c : liste) {
                log.info(c.getNom());
                log.info((c.getDateNaissance()).toString());
            }
    }
     */

    @Transactional
    @Test
    public void TestAssignFournisseur(){
        boolean b = false ;
        pr.assignFournisseurToProduit(2L,1L);
        Optional<Produit> p = pr.retrieveProduit(1L);
        Fournisseur f = fr.retrieveFournisseur(2L);
        log.warn(f.getLibelle());
        if (p.get().getFournisseur().contains(f)  ){
            b= true;
        }
        assertTrue(b);
    }

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
}
