package tn.esprit.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import tn.esprit.demo.repository.DetailProduitRepository;
import tn.esprit.demo.repository.ProduitRepository;
import tn.esprit.demo.service.ClientServiceImpl;

@EnableSwagger2
@SpringBootApplication
public class SpringbootGestionMagasinApplication{

	@Autowired
	private ProduitRepository produitRepository;
	private DetailProduitRepository detailProduitRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootGestionMagasinApplication.class, args);

	}
}
