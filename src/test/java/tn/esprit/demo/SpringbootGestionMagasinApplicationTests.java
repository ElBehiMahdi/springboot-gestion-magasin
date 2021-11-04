package tn.esprit.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.service.ClientService;

import java.util.List;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@SpringBootTest
class SpringbootGestionMagasinApplicationTests {

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
}
