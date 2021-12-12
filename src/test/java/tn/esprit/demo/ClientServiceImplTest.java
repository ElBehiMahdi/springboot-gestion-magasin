package tn.esprit.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.demo.entities.CategorieClient;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.entities.Stock;
import tn.esprit.demo.repository.ClientRepository;
import tn.esprit.demo.service.ClientService;
import tn.esprit.demo.service.StockService;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceImplTest {
    @Autowired
    StockService stockService;

    @Autowired
    ClientService clientService;

    @Test
    public void testAddClient() {
        Client c = new Client();
        c.setCategorieclient(CategorieClient.premium);
        c.setCin(000);
        c.setEmail("");
        c.setDateNaissance(null);
        c.setNom("admin");
        c.setPrenom("admin");
        c.setPhone(000);
        c.setPassword("admin");
        c.setUserName("admin");
        Client newClient = clientService.addClient(c);;
        assertNotNull(newClient);

    }

}
