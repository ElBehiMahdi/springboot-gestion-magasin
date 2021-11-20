package tn.esprit.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.service.ClientService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceImplTest {

    @Autowired
    ClientService clientService;

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
}
