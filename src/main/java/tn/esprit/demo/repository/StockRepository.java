package tn.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.demo.entities.Stock;

public interface StockRepository extends JpaRepository<Stock,Long>{
}
