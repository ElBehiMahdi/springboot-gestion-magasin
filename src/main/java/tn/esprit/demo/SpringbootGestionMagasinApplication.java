package tn.esprit.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.entities.DetailProduit;
import tn.esprit.demo.entities.Produit;
import tn.esprit.demo.repository.DetailProduitRepository;
import tn.esprit.demo.repository.ProduitRepository;
import tn.esprit.demo.service.ClientServiceImpl;

@SpringBootApplication
public class SpringbootGestionMagasinApplication implements CommandLineRunner {

	@Autowired
	private ProduitRepository produitRepository;
	private DetailProduitRepository detailProduitRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootGestionMagasinApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		//create a product
		Produit produit = new Produit("test_code","test_label",467);
		DetailProduit detailProduit = new DetailProduit(null, null);

		produit.setDetailProduit(detailProduit);
		detailProduit.setProduit(produit);
		produitRepository.save(produit);
	}
}
