package tn.esprit.demo.service;

import tn.esprit.demo.entities.Client;
import tn.esprit.demo.entities.Rayon;
import tn.esprit.demo.entities.Stock;

import java.util.List;
import java.util.Optional;

public interface StockService {
    Optional<Stock> get(Long id);
    Stock saveStock(Stock s);
    Stock updateStock(Stock s);
    List<Stock> getAllStocks();
    void deleteStock(Long id);

    boolean checkExists(Long id);

    public List<Stock> warnStock();
}
